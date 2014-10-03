#include<stdio.h>

int max(int a, int b, int c)
{
	if(a>=b && a>=c)
		return a;
	else if(b>=a && b>=c)
		return b;
	else 
		return c;
}

int maxContinguousNo3NeighboursSum(int arr[], int n);



int main()
{
	int arr[] = {1,-2,4,-2,-1,4,7};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x=	maxContinguousNo3NeighboursSum(arr,n);
	printf("%d\n",x);
	return 0;
}

int maxContinguousNo3NeighboursSum(int arr[], int n)
{
	int sumarray[n];
	int i;
	int sum=0;
	if(n==1)
		return arr[0];
	if(n==2)
		return max(arr[0]+arr[1],arr[0],arr[1]);
	for(i=0;i<n;i++)
	{
		sumarray[i] = max(sumarray[i-3]+arr[i-1]+arr[i],sumarray[i-2]+arr[i],sumarray[i-1]);
	}
	return sumarray[n-1];
}