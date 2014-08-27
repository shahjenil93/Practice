class SmallestAndSecondSmallest{
	public static void main(String[] args)
	{
	 	int arr[] = {6,3,5,6,12,5,7,2};
	 	int smallest = arr[0];
	 	int sencond_smallest = arr[0];
	 	for(int i=0;i<arr.length;i++)
	 	{
	 		if(arr[i]<smallest)
	 		{
	 			sencond_smallest = smallest;
	 			smallest = arr[i];
	 		}

	 		if(arr[i]<sencond_smallest && arr[i]>smallest)
	 		{
	 			sencond_smallest = arr[i];
	 		}
	 	}
	 	System.out.println(smallest);
	 	System.out.println(sencond_smallest);
	}
}