/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ll1.parser;

import java.io.*;
import java.util.*;

/**
 *
 * @author mayankmittal
 */

public class LL1Parser {
    
    private static final String Null = "^";
    private static Iterator iterator,iterator1;
    private static int Count;
    
    private static BufferedReader br = null;
    private static final String Path = "C:\\Users\\mayankmittal\\Documents\\NetBeansProjects\\LL1 Parser\\Text Files\\";
    
    private static final List ProdRules = new LinkedList();
    private static final List Firsts    = new LinkedList();
    private static final List Follows   = new LinkedList();
    private static final List Σ = new LinkedList();
    private static final List V = new LinkedList();
    private static final List Input = new LinkedList();
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Read Grammer File and Store it in ProdRules List Dynamically
        String CurrLine;
        br = new BufferedReader(new FileReader(Path+"gram2.txt"));
        while( (CurrLine = br.readLine()) != null){
            // Read and Store the Production Rule
            ProdRules.add(CurrLine);
            // Add Non-Terminals in V List
            Scanner RuleSymbols = new Scanner(CurrLine);
            String Symbol = RuleSymbols.next();
            if(! V.contains(Symbol))
                V.add(Symbol);
        }
        
        // Add Terminals in Σ List
        iterator = ProdRules.iterator();
        while(iterator.hasNext()){
            String Rule = (String) iterator.next();
            Scanner RuleSymbols = new Scanner(Rule);
            RuleSymbols.next();  RuleSymbols.next();
            while(RuleSymbols.hasNext()){
                String Symbol = RuleSymbols.next();
                if(! ( V.contains(Symbol)  ||  Σ.contains(Symbol) ) )
                    Σ.add(Symbol);
            }
        }
        
        
        // Compute and Add Firsts Step by Step
        
        // Compute and Add Firsts of Terminals
        iterator = Σ.iterator();
        while(iterator.hasNext()){
            String Symbol = (String) iterator.next();
            Firsts.add(Symbol);
        }
        
        // Compute and Add Firsts of Non-Terminals where First is Null
        SetInit();
        Count = Σ.size();
        iterator = ProdRules.iterator();
        while(iterator.hasNext()){
            String Rule = (String) iterator.next();
            Scanner RuleSymbols = new Scanner(Rule);
            String NonTerminalSymbol = RuleSymbols.next();
            RuleSymbols.next();
            String Symbol = RuleSymbols.next();
            if(Symbol.equals(Null))
                Firsts.set(Count+V.indexOf(NonTerminalSymbol), Symbol);
        }
        
        // Compute and Add Firsts of Non-Terminals where First is any Symbol but Null
        // Firsts are calculated in Reverse Manner
        for(Count = V.size(); Count>0; Count--){
            String SymbolsInFirst = "";
            String NonTerminal = (String) V.get(Count-1);
            iterator = ProdRules.iterator();
            while(iterator.hasNext()){
                String Rule = (String) iterator.next();
                Scanner RuleSymbols = new Scanner(Rule);
                if(RuleSymbols.next().equals(NonTerminal)){
                    RuleSymbols.next();
                    SymbolsInFirst = SymbolsInFirst + " " + AddToFirst(RuleSymbols);
                }
            }
            // Add all Possible Symbols in First of the Non Terminal
            // It may contain duplicates of any Symbol but Null
            String FirstsOfNonTerminal = (String) Firsts.get(Σ.size()+V.indexOf(NonTerminal));
            if(FirstsOfNonTerminal.equals("empty"))
                Firsts.set(Σ.size()+V.indexOf(NonTerminal), SymbolsInFirst);
            else{
                Scanner tokens = new Scanner(SymbolsInFirst);
                List list = new LinkedList();
                while(tokens.hasNext())
                    list.add(tokens.next());
                if(list.contains(Null))
                    Firsts.set(Σ.size()+V.indexOf(NonTerminal), SymbolsInFirst);
                else
                    Firsts.set(Σ.size()+V.indexOf(NonTerminal), SymbolsInFirst + " " + Null);
            }
            // Remove Duplicates
            Scanner tokens = new Scanner((String) Firsts.get(Σ.size()+V.indexOf(NonTerminal)));
            List list = new LinkedList();
            while(tokens.hasNext()){
                String str = tokens.next();
                if(! list.contains(str))
                    list.add(str);
            }
            String str = "";
            for(Object list1 : list)
                str = str + " " + list1;
            Firsts.set(Σ.size()+V.indexOf(NonTerminal), str);
        }
        
        // Show the Firsts List
        //System.out.println("\n" + Firsts + "\n");
        
        
        // Compute and Add Follows Step by Step
        
        // Initially put $ in Follow of S
        SetInitV();
        Follows.set(0, "$");
        
        
        // Compute and Add Follows of Every Non Terminals
    for(int k=0; k<2; k++){             // Do it twice to ensure the coverage of every possible case
        iterator = ProdRules.iterator();
        // Read all the Production Rules
        while(iterator.hasNext()){
            String Rule = (String) iterator.next();
            Scanner RuleSymbols = new Scanner(Rule);
            List StringList = new LinkedList();
            int pointer = 0, MaxVal = 0;
            while(RuleSymbols.hasNext()){
                StringList.add(RuleSymbols.next());
                MaxVal++;
            }
            String NonTerminal = (String) StringList.get(pointer++);
            pointer++;
            String CheckSymbol;
            // Check For Each Non Terminal in every Production Rule
            while(pointer < MaxVal){
                CheckSymbol = (String) StringList.get(pointer++);
                if(V.contains(CheckSymbol)){
                    String Copy = "";
                    for(int i=pointer; i<MaxVal; i++)
                        Copy = Copy + StringList.get(i);
                    Scanner scanner = new Scanner(Copy);
                    String FollowOfNonTerminal = (String) Follows.get(V.indexOf(NonTerminal));
                    String FollowOfCheckSymbol = (String) Follows.get(V.indexOf(CheckSymbol));
                    
                    // Three cases follows:
                    // If  A -> αBβ  and ...
                    if(scanner.hasNext()){
                        String str = AddToFirst(scanner);
                        Scanner tokens = new Scanner(str);
                        List list = new LinkedList();
                        while(tokens.hasNext())
                            list.add(tokens.next());
                        // 1) ... and β IS null
                        if(list.contains(Null)){
                            list.remove(Null);
                            String f = "";
                            for(Object list1 : list)
                                f = f + " " + list1;
                            FollowOfCheckSymbol = FollowOfCheckSymbol + " " + FollowOfNonTerminal + " " + f;
                        }
                        // 2) ... and β is NOT null
                        else FollowOfCheckSymbol = FollowOfCheckSymbol + " " + str;
                    }
                    // 3) If  A -> αB
                    else FollowOfCheckSymbol = FollowOfCheckSymbol + " " + FollowOfNonTerminal;
                    
                    Follows.set(V.indexOf(CheckSymbol), FollowOfCheckSymbol);
                }
            }
        }
    }
        // Remove Duplicates
        iterator = Follows.iterator();
        int it = 0;
        while(iterator.hasNext()){
            String FollowsOfit = (String) iterator.next();
            Scanner scanner = new Scanner(FollowsOfit);
            List list = new LinkedList();
            String str = "";
            while(scanner.hasNext()){
                String f = scanner.next();
                if(! ( f.equals("empty") || list.contains(f) ) )
                    list.add(f);
            }
            for(Object list1 : list)
                str = str + " " + list1;
            Follows.set(it++, str);
        }
        
        // Show the Follows List
        //System.out.println("\n" + Follows + "\n");
        
        
        // Instantiate Parsing Table
        int rowlen, collen;
        if(Σ.contains(Null)) collen = Σ.size();
        else collen = Σ.size() + 1;
        rowlen = V.size();
        String ParsingTable[][] = new String[rowlen][collen];
        
        // Initialize the Parsing Table
        for(int i=0; i<rowlen; i++)
            for(int j=0; j< collen; j++)
                ParsingTable[i][j] = "Error";
        
        
        // Implement Algorithm to Fill Parsing Table
        List E = Σ;
        E.remove(Null);
        E.add("$");
        iterator = ProdRules.iterator();
        while(iterator.hasNext()){
            String Rule = (String) iterator.next();
            Scanner RuleSymbols = new Scanner(Rule);
            String NonTerminal = RuleSymbols.next();
            RuleSymbols.next();
            String str = AddToFirst(RuleSymbols);
            Scanner scanner = new Scanner(str);
            List list = new LinkedList();
            while(scanner.hasNext())
                list.add(scanner.next());
            
            // If  A -> α  and First(α) CONTAINS null
            if(list.contains(Null)){
                String f = (String) Follows.get(V.indexOf(NonTerminal));
                Scanner sc = new Scanner(f);
                while(sc.hasNext()){
                    String s = sc.next();
                    if(Σ.contains(s))
                        ParsingTable[V.indexOf(NonTerminal)][E.indexOf(s)] = Rule;
                }
            }
            
            // If  A -> α  and First(α) DOES NOT contain null
            iterator1 = list.iterator();
            while(iterator1.hasNext()){
                String s = (String) iterator1.next();
                if(Σ.contains(s))
                    ParsingTable[V.indexOf(NonTerminal)][E.indexOf(s)] = Rule;
            }
        }
        
        // Show the Parsing Table
        /*for(int i=0; i<rowlen; i++){
            System.out.println();
            for(int j=0; j< collen; j++){
                System.out.println(ParsingTable[i][j]);
            }
        }*/
        
        
        
        // Show Implementation Using Stack
        
        // Read Input from File
        br = new BufferedReader(new FileReader(Path+"inp2.txt"));
        CurrLine = br.readLine();
        if(CurrLine != null){      // Input is not empty string
            Scanner input = new Scanner(CurrLine);
            while(input.hasNext())
                Input.add(input.next());
        }
        Input.add("$");     // Add special symbol '$' at the end of the Input
        
        // Initializing stack
        List stack = new LinkedList();
        stack.add("$");
        stack.add((String) V.get(0));
        
        
        // Show Steps of Parsing
        int InputPointer = 0, Status = 0;
        String CurrAction, CurrInput;
        String StackTop, Token;
        
        while(true){
            
            // Re-Define the Parsing Variables
            StackTop = (String) stack.get(stack.size()-1);
            Token = (String) Input.get(InputPointer);
            CurrInput = "";
            for(int i=InputPointer; i<Input.size(); i++)
                CurrInput = CurrInput + Input.get(i) + " ";
            
            // Find Suitable Action
            if(Token.equals("$") && StackTop.equals("$")) CurrAction = "Accept";
            else{
                if(Token.equals(StackTop)) CurrAction = "Shift";
                else CurrAction = "Reduce";
            }
            
            // Show current state of Parsing
            System.out.println();
            System.out.println();
            // Show current STACK
            System.out.printf("Stack:   ");
            for (Object stack1 : stack)
                System.out.printf("%s ", stack1);
            System.out.println();
            // Show current INPUT
            System.out.printf("Input:   %s\n", CurrInput);
            // Show current ACTION
            System.out.printf("Action:  %s\n", CurrAction);
            
            // Use Action to Parse the Input
            switch (CurrAction) {
                case "Shift":
                    stack.remove(stack.size()-1);
                    InputPointer++;
                    break;
                case "Reduce":
                    stack.remove(stack.size()-1);
                    String Rule = ParsingTable[V.indexOf(StackTop)][E.indexOf(Token)];
                    if(Rule.equals("Error")){   // Corresponding Entry in Table is Error
                        Status = -1;
                        break;
                    }
                    Scanner RuleSymbols = new Scanner(Rule);
                    RuleSymbols.next(); RuleSymbols.next();
                    List list = new LinkedList();
                    String Symbol = RuleSymbols.next();
                    if(Symbol.equals(Null)) break;  // Null on the RHS of Production Rule
                    else list.add(Symbol);
                    while(RuleSymbols.hasNext())
                        list.add(RuleSymbols.next());
                    for(int i=list.size()-1; i>=0; i--)
                        stack.add(list.get(i));
                    break;
                case "Accept":
                    Status = 1;
                    break;
            }
            
            // Take Decision Based on Current Status
            if(Status != 0) break;
        }
        
        System.out.println();
        System.out.println();
        
        // Show Final Report of Parsing
        switch (Status) {
            case -1:
                System.out.println("Parsing Unsuccessful with Status -1");
                System.out.println("Hence Given Input doesn't lie in the Given Grammer");
                break;
            case 1:
                System.out.println("Parsing Successful with Status 1");
                System.out.println("Hence Given Input lies in the Given Grammer");
                break;
        }
        
        System.out.println();
        System.out.println();
        
    }
    
    
    
    private static String AddToFirst(Scanner RuleSymbols) {
        String Symbol;
        try{
            Symbol = RuleSymbols.next();
        }catch(Exception ex){return "";}
        
        // If the Symbol is Null
        if(Symbol.equals(Null))
            return Null;
        
        // If the Symbol is a Terminal
        iterator1 = Σ.iterator();
        while(iterator1.hasNext()){
            String Symbol1 = (String) iterator1.next();
            if(Symbol.equals(Symbol1))
                return Symbol1;
        }
        
        // If the Symbol is a Non Terminal
        String FirstsOfNonTerminal = (String) Firsts.get(Σ.size()+V.indexOf(Symbol));
        Scanner tokens = new Scanner(FirstsOfNonTerminal);
        List list = new LinkedList();
        while(tokens.hasNext())
            list.add(tokens.next());
        if(list.contains(Null)){
            String str = "";
            if(RuleSymbols.hasNext()){
                list.remove(Null);
            }
            for(Object list1 : list)
                str = str + " " + list1;
            str = str + " " + AddToFirst(RuleSymbols);
            return str;
        }
        else return FirstsOfNonTerminal;
    }
    
    
    private static void SetInit(){
        iterator = V.iterator();
        while(iterator.hasNext()){
            Firsts.add("empty");
            iterator.next();
        }
    }
    
    private static void SetInitV() {
        iterator = V.iterator();
        while(iterator.hasNext()){
            Follows.add("empty");
            iterator.next();
        }
    }
    
}