class BooleanMatrix
{
	public static void main(String[] args)
	{

		int arr[][] =  {{1,0,0},
						{0,0,0},
						{0,1,0} };
		int n= arr.length;
		int m = arr[0].length;
		int copy[][] = new int[n][m];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j]==1)
				{
					for(int x=0;x<m;x++)
					{
						copy[x][j]=1;
					}

					for(int x=0;x<m;x++)
					{
						copy[i][x]=1;
					}
				}
			}
		}

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}

	}
}