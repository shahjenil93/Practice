import java.util.*;
public class ReadPhoneNumber 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		for(int e=0;e<t;e++)
		{
			String no = sc.next();
			String code = sc.next();
			int k=0;
			String[] pattern = code.split("-");
			int n = pattern.length;
			//System.out.println(n);
			
			int i=0;
			for(i=0;i<n;i++)
			{
				
				for(int j=0;j<Integer.parseInt(pattern[i]);j++)
				{
					int count = 1;					
					while(no.charAt(k)==no.charAt(k+1) && k<no.length()-1)
					{
						
						j++;
						if(j==Integer.parseInt(pattern[i]))
							break;
						if(k==no.length()-2 && no.charAt(k)==no.charAt(k+1))
						{
							count++;
							break;
						}
						if(k==no.length()-2 && no.charAt(k)!=no.charAt(k+1))
						{
							k++;
							break;
						}
						k++;
						
						count++;
						
					}
				
					 if(count==2)
						System.out.print("double ");
					else if(count==3)
						System.out.print("triple ");
					else if(count==4)
						System.out.print("quadruple ");
					else if(count==5)
						System.out.print("quintuple ");
					else if(count==6)
						System.out.print("sextuple ");
					else if(count==7)
						System.out.print("septuple ");
					else if(count==8)
						System.out.print("octuple ");
					else if(count==9)
						System.out.print("nonuple ");
					else if(count==10)
						System.out.print("decuple ");
//					else if(count==11)
//						System.out.print();
					 
					if(no.charAt(k)==(char)'0')
						System.out.print("zero ");
					else if(no.charAt(k)==(char)('0'+1))
						System.out.print("one ");
					else if(no.charAt(k)==(char)('0'+2))
						System.out.print("two ");
					else if(no.charAt(k)==(char)('0'+3))
						System.out.print("three ");
					else if(no.charAt(k)==(char)('0'+4))
						System.out.print("four ");
					else if(no.charAt(k)==(char)('0'+5))
						System.out.print("five ");
					else if(no.charAt(k)==(char)('0'+6))
						System.out.print("six ");
					else if(no.charAt(k)==(char)('0'+7))
						System.out.print("seven ");
					else if(no.charAt(k)==(char)('0'+8))
						System.out.print("eight");
					else if(no.charAt(k)==(char)('0'+9))
						System.out.print("nine");
					k++;
					
				}
				
			}
		}
	}
}
