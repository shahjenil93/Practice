#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main()
{
	int arr[] = {3,2,4,25};
	int n = sizeof(arr)/sizeof(arr[0]);
	int t;
	scanf("%d",&t);
	int M[n+1][t+1];
	int i,j;
	M[0][0]=0;
	for(i=1;i<=t;i++)
	{
		M[0][i]=0; 
	}
	for(i=1;i<=n;i++)
	{
		for(j=0;j<=t;j++)
		{
			M[i][j] = M[i-1][j] || M[i-1][j-arr[i]];
		}
	}
	printf("%d",M[n][t]);
}

