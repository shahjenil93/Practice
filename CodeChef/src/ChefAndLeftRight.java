import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.naming.BinaryRefAddr;


class ChefAndLeftRight 
{
	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		for(int e=0;e<t;e++)
		{
			String st = sc.next();
			long odd = 1;
			int even = 2;
			long count = 1;
			for(int i=0;i<st.length();i++)
			{
				if(count%2==1)
				{
					if(st.charAt(i)=='l')
					{
						odd = 2*odd;
						//odd = odd%((10*10*10*10*10*10*10*10*10)+7);
						odd = odd%(1000000007);
						count++;
						continue;
					}
					if(st.charAt(i)=='r')
					{
						odd = 2*odd+2;
						//odd = odd%((10*10*10*10*10*10*10*10*10)+7);
						odd = odd%(1000000007);
						count++;
						continue;
					}
				}
				
				if(count%2==0)
				{
					if(st.charAt(i)=='l')
					{
						odd = 2*odd-1;
//						odd = odd%((10*10*10*10*10*10*10*10*10)+7);
						odd = odd%(1000000007);
						count++;
						continue;
					}
					if(st.charAt(i)=='r')
					{
						odd = 2*odd+1;
//						odd = odd%((10*10*10*10*10*10*10*10*10)+7);
						odd = odd%(1000000007);	
						count++;
						continue;
					}
				}
			}
			System.out.println(odd);
				
		}
	}
}
