#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int maxContinguousSum(int arr[],int n)
{
	int i,j;
	int sum=0;
	int maxsum;
	
	for(i=0;i<n-1;i++)
	{
		sum=0;
		for(j=i;j<n;j++)
		{
			sum+=arr[j];
			if(maxsum<sum)
			{
				maxsum = sum;
			}
		}
	}
	return maxsum;
}

int maxContinguousSumDP(int arr[], int n)
{
	int m[n];
	int maxsum=0;
	if(arr[0]>0)
		m[0] = arr[0];
	int i;
	for(i=1;i<n;i++)
	{
		if(m[i-1]+arr[i]>0)
		{
			m[i]= m[i-1]+arr[i];
		}
		else
		{
			m[i]=0;
		}
	}
	for(i=0;i<n;i++)
	{
		if(m[i]>maxsum)
			maxsum = m[i];
	}
	return maxsum;
}

int main()
{
	int arr[] = {-2,11,-4,13,-5,2};
	int n =strlen(arr);
	int x = maxContinguousSumDP(arr,n);
	printf("%d",x);	
}