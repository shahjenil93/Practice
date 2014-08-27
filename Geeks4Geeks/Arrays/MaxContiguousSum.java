import java.util.*;

class MaxContiguousSum
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {-2,-3,-4,-1,-2,-1,-5,-3};
		//System.out.println(arr[0]);
		Scanner sc = new Scanner(System.in);
		int max_so_far = 0;
		int max_ending_here = 0;
		for(int i=0;i<arr.length;i++)
		{
			max_ending_here=max_ending_here+arr[i];
			if(max_ending_here<0)
			{
				max_ending_here = 0;
			}
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		System.out.println(max_so_far);
		
	}
}