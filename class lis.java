class lis
{
	public static void main(String[] args)
	{
		int arr[] = {10,22,9,33,21,50, 41,60}
		n = 8;
		System.out.println(subseq(arr[],n));
	}

	int subseq(int arr[], int n,)
		{
			int lis[] = new int(n);
			int i,j,max=1;
			for(i=0;i<n;i++)
			{
				lis[i]=1;
			}

			for(i=1;i<n;i++)
				{
					for(j=0;j<i;j++)
					{
						if(arr[j]<arr[i] && lis[j]<lis[i]+1)
						{
							lis[i] = lis[j]+1;	
						}
					}
			}

			for(i=0;i<n;i++)
			{
				if(max<lis[i])
				{
					max = list[i];
				}
			}
			return max;
		}
}