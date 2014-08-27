import java.util.*;
class modified_mergesort
{

	public static void main(String[] args)
	{
		int[] array = {5,4,3,2,1};
		modified_mergesort example = new modified_mergesort();
		example.mergesort_demo(array,0,array.length-1);

	}

	public static void mergesort_demo(int[] array, int start, int end)
	{
		int n = array.length;
		int[] helper = new int[n];
		int mid = (start+end)/2;
		if(start<end)
		{
			 mergesort_demo(array, 0, mid);
			 mergesort_demo(array, mid+1, end);
			 merge(array, helper, start, end, mid);
		}
	}

	public static void merge(int[] array, int[] helper, int start, int end, int middle )
	{
		for(int i =start; i<end; i++)
		{
			helper[i] = array[i];
		}

		int i = start;
		int k = start;
		int j = middle+1;

		while(i<middle && j<end)
		{
			if(array[i] < array[j])
			{
				helper[k] = array[i];
				i++;
			}
			else
			{
				helper[k] = array[j];
				j++;
			}
			k++;
		}

		while(i<middle)
		{
			helper[k] = array[i];
			i++;
			k++;
		}

		for(int x=0;i<helper.length;i++)
		{
			System.out.print(helper[i]);
		}
	}
		

	
}