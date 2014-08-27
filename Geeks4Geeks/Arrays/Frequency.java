import java.util.*;

class SortByFrequency
{
	public static void main(String[] args)
	{
		int arr[] = { 2,5,2,8,5,6,8,8};
		Arrays.sort(arr);
		int n = arr.length;
		int count=1;
		int count2d[][] = new int[n][2];
		count2d[0][0] = arr[0];
		count2d[0][1] = 1;
		int j=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==arr[i-1])
			{
				count++;
				count2d[j][0] = arr[i];
				count2d[j][1] = count;
			}

			else
			{
				j++;
				count=1;
				count2d[j][0] = arr[i];
				count2d[j][1] = count;	
			}
		}

		for(j=0;j<count2d.length;j++)
		{
			System.out.println(count2d[j][0] +"with count"+ count2d[j][1]);
		}
		
	}
}