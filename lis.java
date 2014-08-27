class lis
{
	public static void main(String[] args)
	{
		int arr[] = {10,22,9,33,21,50, 41,60};
		int n = 8;
		System.out.println(subseq(arr,n));
	}

	static int subseq(int arr[], int n)
		{
			int lis[] = new int[n];
			int i,j,max=1;
			for(i=0;i<n;i++)
			{
				lis[i]=1;
			}

			for(i=1;i<n;i++)
				{
					for(j=0;j<i;j++)
					{
						if(arr[j]<arr[i] && lis[i]<lis[j]+1)
						{
							lis[i] = lis[j]+1;	
						}
					}
			}

			for(i=0;i<n;i++)
			{
				if(max<lis[i])
				{
					max = lis[i];
					System.out.println(arr[i]);
				}
			}
			return max;
		}
}