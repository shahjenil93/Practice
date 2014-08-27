import java.util.*;
import java.lang.*;

class MaxSumNoAdjacent
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {5,5,10,40,50,35};
		
		Scanner sc = new Scanner(System.in);
		//int d = sc.nextInt();
		MaxSumNoAdjacent ms = new MaxSumNoAdjacent();
		int maxsum=ms.rotate(arr);
		System.out.println(maxsum);

	}

	public int rotate(int arr[])
	{
		int incl=arr[0];
		int excl=0;
		int excl_new = 0;

		for(int i=1;i<arr.length;i++)
		{
			excl_new = Math.max(incl,excl);

			
			incl = (excl+arr[i]);
			excl = excl_new;
			System.out.println("incl"+incl);
			System.out.println("excl"+excl);
		}	
		return(Math.max(incl,excl));
	}
}
