#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int lisLength(int arr[], int n);

int main()
{
	int arr[] = {5,6,2,3,4,1,9,9,8,9,5};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = lisLength(arr,n);
	printf("%d\n",x);
}

int lisLength(int arr[], int n)
{
	//printf("value of n is %d",n);
	int i,j;
	int temp =0;
	int table[n];
	for(i=0;i<n;i++)
		table[i] = 1;
	for(i=0;i<n;i++)
	{
		for(j=0;j<i;j++)
		{
			if(table[i]<table[j]+1 && arr[i]>arr[j])
			{
				table[i] = table[j]+1;
			}
		}
	}

	for(i=0;i<n;i++)
	{
		//printf("%d ",table[i]);
		if(table[i]>temp)
			temp = table[i];
	}
	return temp;
}

//another method is sort and array and find the LCS with the original array


