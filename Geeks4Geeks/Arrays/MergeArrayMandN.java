import java.util.*;

class MergeArrayMandN
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {4,-1,6,-1,8,-1,12};
		int arr2[] = {1,3,7};
		//System.out.println(arr[0]);
		Scanner sc = new Scanner(System.in);
		MergeArrayMandN mandn = new MergeArrayMandN();
		mandn.moveToEnd(arr);
		mandn.merge(arr,arr2);
		mandn.print(arr2);

	}

	public void moveToEnd(int arr[])
	{
		int i = arr.length-1;
		int j = arr.length-1;
		int temp =0;
		for(;i>=0;i--)
		{
			if(arr[i]!=-1)
			{
				temp = arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				j--;
			}
		}

	}

	public void merge(int arr[], int arr2[])
	{
		int min = Math.min(arr.length,arr2.length);
		int i=0;
		int n = arr2.length-1;
		int j=0;
		while(i!=arr2.length-1 || n!=arr.length-1)
		{
			if(arr2[i]<arr[n])
			{
				arr[j]=arr2[i];
				i++;
				j++;
			}
			else
			{
				arr[j]=arr[n];
				n++;
				j++;
			}
		}

	}

	public void print(int arr[])
	{
	for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
