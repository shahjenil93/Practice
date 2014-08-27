import java.util.Scanner;
class substring
{
	public static void main(String[] args)
	{
		int i;
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for(i=0;i<t;i++)
		{
			String s = sc.next();
			String sub = sc.next();
			int j,k;
			for(j=0;j<s.length();)
			{
				k=0;
				while(k<sub.length())
				{
					if(s.charAt(j)==sub.charAt(k))
					{
						j++;
						k++;
						//if
					}
					else
					{
						k=0;
						j++;
						continue;
					}
				}
				if(k==sub.length())
				{
					System.out.println(sub);
				}
				else
				{
					System.out.println("-1");
				}
			}

		}
	}
}