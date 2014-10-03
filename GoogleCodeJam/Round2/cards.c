#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void swap(int *a, int *b);

int main()
{
	int t,i;
	scanf("%d",&t);
	for(i=0;i<t;i++)
	{
		int n,k,j, count=0;
		scanf("%d %d",&n, &k);
		int arr[n];
		for(j=0;j<n;j++)
		{
			scanf("%d",&arr[j]);
		}
		for(j=0;j<n-2;j++)
		{
			if(arr[j+1]-arr[j]==k && arr[j+2]-arr[j+1]==k)
			{
				arr[j]=-1;
				arr[j+1]=-1;
				arr[j+2]=-1;
				swap(&arr[j],&arr[n-3]);
				swap(&arr[j+1],&arr[n-2]);
				swap(&arr[j+2],&arr[n-1]);
				n = n-3;
			}
		}
		for(j=0;j<n;j++)
		{
			if(arr[j]!=-1)
			{
				count++;
			}
		}
		printf("%d\n",count);
	}

}

void swap(int *a, int *b)
{
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}