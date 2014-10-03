#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}

int main()
{
	
	 	int n;
	 	scanf("%d",&n);
	 	int arr[n];
	 	int i,j;
	 	for(i=0;i<n;i++)
	 	{
	 		scanf("%d",&arr[i]);
	 	}

	 	int count = 1;
	 	int lis[n];
	 	lis[0]=1;
	 	for(i=1;i<n;i++)
	 	{
	 		if(arr[i-1]<arr[i])
	 		{
	 			count++;
	 			lis[i] = count;
	 		}
	 		else
	 		{
	 			count = 1;
	 			lis[i] = count;
	 		}
	 	}
	 	// 	printf(" lis1");
	 	// for(i=0;i<n;i++)
	 	// {
	 	// 	printf("%d ",lis[i]);
	 	// }

	 	for(i=n-1;i>1;i--)
	 	{
	 		if(arr[i]<arr[i-1] && lis[i]>=lis[i-1])
	 		{
	 			lis[i-1] = lis[i]+1;
	 		}
	 	}

	 	// printf(" lis");
	 	// for(i=0;i<n;i++)
	 	// {
	 	// 	printf("%d ",lis[i]);
	 	// }

	 	int sum = 0;
	 	for(i=0;i<n;i++)
	 		sum+= lis[i];

	 	printf("%d\n",sum);
	
}