import java.lang.Math.*;
class lis_sum
{
	public static void main(String[] args)
	{
		int arr[] = {10,22,9,33,21,50,41,60};
		int n = 8;
		System.out.println(sum_sub(arr,n));
	}

	static int sum_sub(int arr[], int n)
	{
		int i,j, max=0;
		int lis[] = new int[n];
		for(i=1;i<n;i++)
		{
			lis[i] = arr[i];
		}
		for (i=1;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				if(arr[j]<arr[i] && lis[i]<lis[j]+arr[i])
				{
					lis[i] = lis[j] + arr[i];
				}
			}
		}
		max= findmax(lis,n);
		return max;
	}

	static int findmax(int lis[], int n)
	{
		int temp=0;
		for(int i=0;i<n;i++)
		{
			temp=lis[0];
			if(lis[i]>temp)
			{
				temp = lis[i];
			}
		}
		return temp;
	}
}