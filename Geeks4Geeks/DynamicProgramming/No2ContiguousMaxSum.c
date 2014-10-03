#include<stdio.h>

int max(int a, int b)
{
	if(a>b)
		return a;
	else
		return b;
}

int maxContinguousNoNeighboursSum(int arr[], int n);



int main()
{
	int arr[] = {1,-2,4,-2,-1,4,7};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x=	maxContinguousNoNeighboursSum(arr,n);
	printf("%d\n",x);
	return 0;
}

int maxContinguousNoNeighboursSum(int arr[], int n)
{
	int i;
	int sum = 0;
	int sumarray[n];
	if(n==1)
		return arr[0];
	else if(n==2)
		return max(arr[0],arr[1]);
	else
	{
		for(i=0;i<n;i++)
		{
			sumarray[i] = max(arr[i]+sumarray[i-2],sumarray[i-1]);
		}
	}	
	return sumarray[n-1];
}