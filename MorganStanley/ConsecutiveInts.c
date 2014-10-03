#include<stdio.h>
#include<stdlib.h>

int sum_upto_n(int n);

int main()
{
	int n;
	scanf("%d",&n);
	int i=0;
	int sum=0;
	while(sum<n)
	{
		sum = sum_upto_n(++i);
	}
	if(sum==n)
	{
		printf("%d\n",i);
	}
	int k;
	while(sum>n)
	{
		
		k = sum-n; 
		if(k%2==0 && k/2<=sum)
		{
			printf("%d\n",i);
			break;
		}
		else
		{
			sum = sum_upto_n(++i);
		}
	}


}

int sum_upto_n(int n)
{
	return (n*(n+1))/2;
}