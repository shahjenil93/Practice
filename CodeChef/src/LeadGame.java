import java.util.Scanner;


public class LeadGame 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();
		int temp=0;
		int n1=0;
		int n2=0;
		for(long i=0;i<t;i++)
		{
			n1 += sc.nextInt();
			n2 += sc.nextInt();
			
			if(Math.abs(temp)<Math.abs(n1-n2))
				{
					temp = n1-n2;
				}
		}
		if(temp>0)
		{
			System.out.print("1 ");
		}
		else
		{
			System.out.print("2 ");
		}
		System.out.println(String.valueOf(Math.abs(temp)));
	}

}
