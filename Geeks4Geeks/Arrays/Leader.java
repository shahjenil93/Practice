public class Leader{
	public static void main(String[] args)
	{

		int arr[] = {16,17,4,3,5,2};
		int i;
		int temp = arr[arr.length-1];
		System.out.println(temp);
		for(i=arr.length-1;i>0;i--)
		{
			if(arr[i]>temp)
			{
				temp = arr[i];
				System.out.println(arr[i]);
			}
		}
	}
}