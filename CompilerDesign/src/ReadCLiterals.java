import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCLiterals 
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr;
			fr = new FileReader("/Users/jenil/Documents/Programming/Practice/Geeks4Geeks/Arrays/FindMaxSum_C.c");
	      char [] a = new char[820];
			fr.read(a);
			for(int i=0;i<a.length;i++)
			{
				if(a[i]>=48 && a[i]<=57)
				{
					System.out.print(a[i]);
					if(a[i]==';')
					{
						System.out.println();
					}
				}
				
				if(a[i]=='"')
					{
					i++;
					Boolean string_bool = true;
					while(string_bool)
						{
						
						System.out.print(a[i]);
						i++;
						if(a[i]=='"')
							{
							System.out.println();
							string_bool=false;
							}
						}
					}
				
				if(a[i]=='\'')
				{
				i++;
				Boolean char_bool = true;
				while(char_bool)
					{
					System.out.print(a[i]);
					i++;
					if(a[i]=='\'')
						{
						System.out.println();
						char_bool=false;
						}
					}
				}
			}
			
		 // reads the content to the array
			 System.out.println("File read starts");
			for(char c : a)
	      {
	    	  System.out.print(c); //prints the characters one by one
	      }
			fr.close();
	}
}
