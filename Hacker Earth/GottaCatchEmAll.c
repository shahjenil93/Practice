#include<stdio.h>
#include<stdlib.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}

int main()
{
	int n;
	scanf("%d",&n);
	int i;
	int arr[n];
	int days = 0;
	int count=0;
	for(i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	qsort(arr,sizeof(arr)/sizeof(arr[0]), sizeof(arr[0]), cmpfunc);

	for(i=n-1;i>=0;i--)
	{
		if(arr[i]>days)
		{
			count+=(arr[i]-days);
			days+=(arr[i]-days);
			days--;	
		//	printf("%d %d %d\n",i,count, days);

			
		}
		else
		{
			days--;
		}
	}
	count = count + 2;
	//printf("\n");
	printf("%d\n",count);

}