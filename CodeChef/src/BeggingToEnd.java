import java.util.Scanner;

class BeggingToEnd
{
	
	public String updateLine(String line1)
     {
		char[] char1 = line1.toCharArray();
        char cache1 = char1[0];
        for(int x = 0;x < line1.length() - 1;x++)
        {
            char1[x] = char1[x+1];
        }
        char1[line1.length()-1] = cache1;
        line1 = line1.valueOf(char1);
        return line1;
     }

	public int lcs(String str1, String str2, int t)
	{
		    for (int i = 0; i < t; i++) {
		        if (str1.charAt(i) != str2.charAt(i)) {
		            return str1.substring(0, i).length();
		        }
		    }
		    return str1.substring(0, t).length();
		}
		  

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BeggingToEnd b2g = new BeggingToEnd();
		
		//	b2g.updateLine();
			//System.out.println(b2g.line1);
			
	        Scanner input = new Scanner(System.in);
	        int t = input.nextInt();
	        if(t==0)
	        {
	        	System.out.println(0);
	        	return;
	        }
	        String str1 = input.next();
	        String str2 = input.next();
	        int count[] = new int[t];
	        for(int j=0;j<t;j++)
	        {
	        	str2=b2g.updateLine(str2);
	        	count[j]=b2g.lcs(str1, str2,t);
	        }
	       int temp =0;
	       int pos = 0;
	        for(int j=0;j<t;j++)
	        {
	        	if(count[j]>temp)
	        	{
	        		temp = count[j];
	        		pos = j;
	        	}
	        }
	        System.out.println(pos+1);
	}	
}