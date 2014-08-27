import java.util.*;
class sorting
{
	public static void main(String[] args)
	{
		int arr[] = new int[] {5,12,3,54,6,23,54,23};
		Arrays.sort(arr);
		System.out.println("hello");
		for(int i=0;i<8;i++)
		{
			System.out.print(arr[i] + " ");
		}	
		Arrays.sort(arr[], Collections.reverseOrder());
		for(int i=7;i>0;i++)
		{
			System.out.print(arr[i]);
		}
	}
}