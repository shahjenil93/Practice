import java.util.Arrays;
import java.util.Scanner;


class CoolpingPies 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for  (int i=0;i<t;i++)
		{
			int n = sc.nextInt();
			int pies[] = new int[n];
			int rack[] = new int[n];

			for(int j=0;j<n;j++)
			{
				pies[j] = sc.nextInt();
			}
			
			for(int j=0;j<n;j++)
			{
				rack[j] = sc.nextInt();
			}
			Arrays.sort(pies);
			Arrays.sort(rack);
			
			int count =0 ;
			int a=0, b=0;
			while(a<n && b<n)
			{
				if(pies[a]<=rack[b])
				{
					count++;
					a++;
					b++;
				}
				else
				{
					b++;
				}
				
			}
			System.out.println(count);
		}
	}
}
