class Sorted2dMatrix
{
	public static void main(String[] args)
	{
		int arr[][]={{10,20,30,40},
					{15,25,35,45},
					{27,29,37,48},
					{32,33,39,50}};
		int n = 34;
		int x = arr.length;
		int y = arr[0].length;
		int j=0;
		for(int i=x-1;i>0;i--)
		{
			if(arr[i][j]==n)
				System.out.println(n);
			if(arr[i][j]>n)
			{
				i--;
			}

			if(arr[i][j]<n)
			{
				j++;
			}

		}
	}
}