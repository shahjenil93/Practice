import java.util.*;
class Bubble
{
	public static void main(String[] args)
	{
		int[] arr = {4,3,2,1};

	}

	static void bubblesort(int[] arr)
	{
		int i,j;
		for (i=arr.length-1;i>0;i--)
		{
			for(j=0;j<i;j++)
			{
				if(arr[i]>arr[i+1])
				{
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}

		for(int k = 0; k<arr.length;k++)
		{
			System.out.println(arr[k]);
		}
	}
}