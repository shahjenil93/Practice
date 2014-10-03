import java.util.Scanner;

class FunWithRotation 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for(int f=0;f<n;f++)
		{
			arr[f] = sc.nextInt();
		}
		
		int shift=0;
		for(int e=0;e<m;e++)
		{
			String code = sc.next();
		//	char c = sc.
			int d = sc.nextInt();
			long temp[] = new long[d];
			
			if(code.charAt(0)=='R')
			{
				System.out.println(arr[(shift+d-1)%n]);
			}
			if(code.charAt(0)=='C')
			{
				shift = (shift + d)%n;
			}
			if(code.charAt(0)=='A')
			{
				shift = (shift-d)%n;
			}
		}
	}
}
