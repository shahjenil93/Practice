class Maxcontigoussum
{
	static int maxContingousSum(int A[], int n)
	{
		int M[] = new int
		[n];
		for (int i=0; i<n; i++)
		{
			M[i] = 0;
		}

		int maxsum=0;
		if(A[0]>0)
		{
			M[0]=A[0];
		}
		else
		{
			M[0] = 0;
		}

		for(int i=1; i<n; i++)
		{
			if(M[i-1] + A[i] > 0)
			{
				M[i] = M[i-1] + A[i];
			}
			else
			{
				M[i]=0;
			}
		}

		for(int i=0;i<n;i++)
		{
			if(M[i]>maxsum)
			{
				maxsum = M[i];
			}
		}
		return maxsum;
	}	

	public static void main(String[] args)
	{
		int n=6;
		int arr[] = new int[] {1, -3, 4, -2, -1, 6};
		int sum = maxContingousSum(arr, n);
		System.out.println(sum);

	}
}