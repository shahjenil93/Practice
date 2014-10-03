#include<stdio.h>

int maxSum(int arr[], int n);

int main()
{	
	int arr[] = {1,-3,4,-2,-1,6};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = maxSum(arr,n);
	return 0;
}

int maxSum(int arr[], int n)
{
	int sum=0, maxsum =0;
	int i;
	for(i=0;i<n;i++)
	{
		sum+=arr[i];
		if(sum<0)
		{
			sum = 0;
		}

		if(sum>maxsum)
		{
			maxsum = sum;
		}
	}
	printf("%d\n",maxsum);
	return maxsum;
}