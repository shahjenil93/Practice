import java.util.Arrays;
import java.util.Scanner;


class AndOperation 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int temp = 0;
		int t = sc.nextInt();
		int arr[] = new int[t];
		for(int i=0; i<t; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		for(int i=arr.length;i>1;i--)
		{
			int j=i-1;
			for(;j>0;j--)
			{
				if((arr[i]&arr[j])>temp)
				{
					temp = arr[i]&arr[j];
				}
			}
		}
		System.out.println(temp);
	}
}
