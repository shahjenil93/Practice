import java.util.*;

class RotateArray
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {1,2,3,4,5,6,7,8};
		
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		RotateArray ra = new RotateArray();
		ra.rotate(arr,d);
		

	}

	public void rotate(int arr[], int d)
	{
		int shift=d;
		int temp[] = new int[arr.length];
		for(int i=0;i<d;i++)
		{
			temp[i] = arr[i];
		}

		int i=0;
		while(shift<arr.length)
		{
			
			arr[i] = arr[shift];
//			System.out.println("To shift"+arr[shift]);
			i++;
			shift++; 
		}

		for(i=0;i<arr.length;i++)
		{
		//	System.out.println(arr[i]);
		}

		for(i=0;i<d;i++)
		{
			arr[shift-d+i]=temp[i];
//			System.out.println("Remaining part index"+(shift-d+i));
			
		}

		for(i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

	
}
