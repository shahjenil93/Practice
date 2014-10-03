import java.io.*;
import java.util.*;

public class OperatorPrecedence {
	static String delims = "[ ]+";
	static int chk = 0;
	static String[] tokens = null;
	static String[] tokens2 = null;
	static ArrayList<String> al = new ArrayList<String>();
	static ArrayList<String[]> prec = new ArrayList<String[]>();
	static ArrayList<String[]> gram = new ArrayList<String[]>();
	static ArrayList<String> inp = new ArrayList<String>();
	static ArrayList<String> stack = new ArrayList<String>();
	static ArrayList<String> stacktop = new ArrayList<String>();
	static String input = null;
	
	public static void main(String args[]){
		
		try{
			  // Open the file that is the first  command line parameter
			  FileInputStream fstream = new FileInputStream("precedence.txt");
			
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				  if(chk==0) {
					  tokens = strLine.split(delims);
					  chk = 1;
				  }
				  prec.add(strLine.split(delims));
			  System.out.println (strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	
		System.out.println("hello");

		
		for(int j=0; j < prec.size(); j++) {
			System.out.println();
		for (int i = 0; i < prec.get(j).length; i++)
		    System.out.print(prec.get(j)[i]+" ");
		}

		System.out.println("hello2"+prec.get(0).length);
		
	//System.out.println("Size1 = "+prec.size()+ "Size2 = " +prec.get(0).length);
	if(prec.size()!=prec.get(0).length) {
		System.out.println("Error in precedence table");
		System.exit(-1);
	}
	
	ArrayList<int[]> prec2 = new ArrayList<int[]>();
	for(int j=1; j<prec.size(); j++) {
		System.out.println();
		System.out.print("For "+prec.get(0)[j]+":");
		for(int i=1; i<prec.get(j).length; i++) {
			System.out.print(" "+prec.get(j)[i]);
		}
	}
	String arrow_delim = "->|[ ]+";
	String or_delim = "[ ]+";
	try{
		  // Open the file that is the first command line parameter
		
		  FileInputStream fstream = new FileInputStream("grammar.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)   {
		  gram.add(strLine.split(arrow_delim));  
		  }
		  //Close the input stream
		  in.close();
		}
	catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	tokens = null;
	
	try{
		  // Open the file that is the first 
		  // command line parameter
		  FileInputStream fstream = new FileInputStream("input.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)   {
		  tokens = strLine.split(delims);  
		  }
		  for(int i=0; i<tokens.length; i++){
			  if(tokens[i].matches("[1-9][0-9]*|[0-9]*.[0-9]+|[_a-zA-Z][a-zA-Z0-9_]*")) //numbers | decimal | alphabet
				  tokens[i] = "i";
			  else {
				 // tokens[i].
			  }
		 }
		  for(int i=0; i<tokens.length; i++){
			//  System.out.println("hello3");
			  System.out.println(tokens[i]);
			  inp.add(tokens[i]);
		 }
		 inp.add("$"); 
		  in.close();
		}
	catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	
	stack.add("$");
	stacktop.add("$");
	
	compare(stack, stacktop, inp);
	
	}
	
	public static void compare(ArrayList<String> stack, ArrayList<String> stacktop, ArrayList<String> inp){
		int inp_pointer = 0, iter = 0;
		String inptop = inp.get(0);
		String result = null; 
		System.out.print("Stack \t Input \t Operation \n");
		while(!(stacktop.get(stacktop.size()-1).equals("$") && inp.get(inp_pointer).equals("$"))) {
			iter++;
			for(int i=0; i<stack.size(); i++){
				System.out.print(stack.get(i));
			}
			System.out.print("\t");
			for(int i=inp_pointer; i<inp.size(); i++){
				//System.out.print("foo");
				System.out.print(inp.get(i));
			}
			
			System.out.print("\t");
			result = compareprec(stacktop.get(stacktop.size()-1), inp.get(inp_pointer));
			if(result.equals("l")) {
				stack.add(inp.get(inp_pointer++));
				stacktop.add(stack.get(stack.size()-1));
				System.out.print("\t");
				System.out.print("S \n");
			}
			if(result.equals("g")) {
				System.out.print("\t");
				System.out.print("R \n");
				Reduction rn = reduce(stack);
				while(rn.stack_replaced_till>0) {
					if(stack.get(stack.size()-1).equals(stacktop.get(stacktop.size()-1))&& stacktop.get(stacktop.size()-1)!="$") 
					{
						stacktop.remove(stacktop.size()-1);
					}
					
					stack.remove(stack.size()-1);
					rn.stack_replaced_till--;
				}
				stack.add(gram.get(rn.gram_rule)[0]);
				
			}
			
			//System.out.println("In iteration "+iter+" Input top "+inp.get(inp_pointer) +" Stack top "+stacktop.get(stacktop.size()-1));
			for(int i=0; i<stack.size(); i++){
				//System.out.print(" "+stack.get(i));
			}
			//System.out.println();
		}
		for(int i=0; i<stack.size(); i++){
			System.out.print(stack.get(i));
		}
		System.out.print("\t");
		for(int i=inp_pointer; i<inp.size(); i++){
			System.out.print(inp.get(i));
		}
		System.out.print("\t");
		System.out.print("End\n");
		System.out.println("Parsing Successful");
	}

	public static Reduction reduce(ArrayList<String> stack){
		Reduction rn = new Reduction();
		int red = 0, recur = 1;
		String chek = null;
		chek = stack.get(stack.size()-1); 
		while(red!=1) {
			for(int i=0; i<gram.size(); i++){
				for(int j=1; j<gram.get(i).length; j++){
					if(gram.get(i)[j].equals(chek)) {
						red = 1;
						Reduction.gram_rule = i;
						Reduction.in_rule = j;
						Reduction.stack_replaced_till = recur;
						//System.out.println("Reducing the part:"+chek);
						return rn;
					}
				}
			}
			recur++;
			chek = null;
			StringBuilder sb = new StringBuilder();
			for(int i=1, j=recur; i<=recur; i++, j--){
				sb.append(stack.get(stack.size()-j));
			}
			chek = sb.toString();
		}
		if(red!=1){
			System.out.println("Incorrect Input");
			System.exit(-1);
		}
		return rn;
	}
	public static String compareprec(String stacktop, String inptop) {
		int stop = 0, itop = 0;
		for(int j=1; j<prec.size(); j++){
			if(prec.get(0)[j].equals(stacktop)) stop = j;
			if(prec.get(0)[j].equals(inptop)) itop = j;
			}
		return prec.get(stop)[itop];
	}
		/*for(int j=1; j<prec.size();\
		 * 
			System.out.print("For "+prec.get(0)[j]+":");
			for(int i=1; i<prec.get(j).length; i++) {
				System.out.print(" "+prec.get(j)[i]);
			}
		}*/
}

