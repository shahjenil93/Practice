import java.util.Scanner;


class ChefAndGift 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=0;x<t;x++)
		{
			
			int n= sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			
			int count=0;
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
				if(arr[i]%2==0)
				{
					count++;
				}
			}
			
			if(count>=k)
			{
				if(k==0 && count==n)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else
			{
			System.out.println("NO");
			}
		}
	}
}
