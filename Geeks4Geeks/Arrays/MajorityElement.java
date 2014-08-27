import java.util.*;

class MajorityElement
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {2,2,3,5,2,2,6};
		//System.out.println(arr[0]);
		Scanner sc = new Scanner(System.in);
		int maj_index = 0;
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(count==0)
			{
				maj_index = arr[i];	
				count++;
				continue;
			}

			else if(maj_index == arr[i])
			{
				count++;
			}
			else
			{
				count--;
			}
	
		}
		int maj = maj_index;
		int verify_count=0;
		if(count>0)
		{
			
			for(int i=0;i<arr.length;i++)
			{	
				if(arr[i]==maj)
					verify_count++;
			}
		}
		if(verify_count>arr.length/2)
			System.out.println(maj);
		else
		{
			System.out.println("No");
		}

		
	}
}