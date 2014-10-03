#include<stdio.h>
#include<stdlib.h>

int bitonic(int arr[], int n);

int main()
{
	int arr[]={1,2,3,4,5,4,3,1};
	int n = sizeof(arr)/(sizeof(arr[0]));
	int x = bitonic(arr,n);
	printf("%d\n",x);
	return 0;
}

int bitonic(int arr[], int n)
{
	//first compute lis of the given array

	int temp1[n];
	int i,j;
	for(i=0;i<n;i++)
	{
		temp1[i] = 1;
	}

	for(i=1;i<n;i++)
	{
		for(j=0;j<i;j++)
		{
			if(arr[i]>arr[j] && temp1[i]<temp1[j]+1)
			{
				temp1[i] = temp1[j]+1;
			}
		}
	}
	int max=0;
	

	//now compute lds of the array
	int temp2[n];
	for(i=0;i<n;i++)
	{
		temp2[i]=1;
	}

	for(i=n-2;i>=0;i--)
	{
		for(j=n-1;j>i;j--)
		{
			if(arr[i]<arr[j] && temp2[i]<temp2[j]+1)
			{
				temp2[i] = temp2[j]+1;
			}
		}
	}
	for(i=0;i<n;i++)
	{
		if(temp1[i]>max)
		{
			max = temp1[i];
		}
	}
	//printf("%d\n",max);


	max=0;

	for(i=0;i<n;i++)
	{
		if(temp1[i]+temp2[i]-1 > max)
		{
			max = temp1[i]+temp2[i]-1;
		}
	}
	//printf("%d",max);
	return max;
}