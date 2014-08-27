import java.util.*;

class VerifySum
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {1,-8,12};
		//System.out.println(arr[0]);
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int l=0;
		int r = (arr.length)-1;
		Arrays.sort(arr);
		while(l<r)
		{
			if(arr[l]+arr[r]==x)
			{
				System.out.println("Yes");
				return;
			}
			else if(arr[l]+arr[r]>x)
				r--;
			else if(arr[l]+arr[r]<x)
				l++;
		}
		System.out.println("NO");
	}
}