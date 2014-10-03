#include<stdio.h>

int MaxScore(int arr[], int n);

int max(int a, int b, int c)
{
	if(a>=b && a>=c)
		return a;
	else if(b>=a && b>=c)
		return b;
	else
		return c;
}

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		int i;
		int arr[n];
		for(i=0;i<n;i++)
		{
			scanf("%d",&arr[i]);
		}
		int x =	MaxScore(arr,n);
		printf("%d\n",x);
	}
	return 0;
}

int MaxScore(int arr[], int n)
{
	int i;
	int sum[n+1];
	int dp[n+1];
	sum[0] = arr[0];
	//dp[] = 0;
	dp[0] = arr[0];
	dp[1] = arr[0]+arr[1];
	dp[2] = arr[0]+arr[1]+arr[2];
	for(i=1;i<n;i++)
	{
		sum[i] = sum[i-1] + arr[i];
	}

	for(i=0;i<n;i++)
	{
		printf("%d\n",sum[i]);
	}

	for(i=3;i<=n;i++)
	{

		//printf("%d",max(2,3,2));
		dp[i] = max((sum[i-3]-dp[i-3]+arr[i-2]+arr[i-1]+arr[i]), (sum[i-2]-dp[i-2]+arr[i-1]+arr[i]), (sum[i-1]-dp[i-1]+arr[i]));
		printf("%d\n",dp[i]);
	}
	return dp[n-1];
}