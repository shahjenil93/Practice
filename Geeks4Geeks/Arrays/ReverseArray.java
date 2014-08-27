import java.util.*;

class ReverseArray
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {4,6,3,6,3,2};
		int arr2[] = {1,3,7};
		//System.out.println(arr[0]);
		//Scanner sc = new Scanner(System.in);
		ReverseArray ra = new ReverseArray();
		ra.reverse(arr);
		

	}

	public void reverse(int arr[])
	{
		int start=0;
		int end=arr.length-1;
		while(start<end)
		{
			int temp = 0;
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;	
			start++;
			end--;		
		}
	
	for(int i=0;i<arr.length;i++)
	{
		System.out.println(arr[i]);
	}
	}

	
}
