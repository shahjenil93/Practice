#include<stdio.h>
#include<stdlib.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}

int main()
{
	int arr[6];
	int i;
	for(i=0;i<6;i++)
	{
		scanf("%d",&arr[i]);
	}

	qsort(arr, 6, sizeof(arr[0]), cmpfunc);
	
	int leg = arr[2];
	int b1[2];
	for(i=0;i<2;i++)
	{
		b1[i] = 0;
	}

	int j=0;
	int count=0;
	int flag = 0;

	for(i=0;i<6;i++)
	{
		if(arr[i]==leg)
		{
			count++;
	//		printf("count = %d",count);
	//		printf("leg = %d",leg);
		}
	}

	if(count >=4)
	{
		flag = 1;
		for(i=0;i<6;i++)
		{
			if(arr[i]!=leg)
			{
				b1[j] = arr[i];
				j++;
				arr[i] = 0;
			}
		}
	}

	if(flag==1)
	{
		if(b1[0]==b1[1])
		{
			printf("Elephant\n");
		}
		else
		{
			printf("Bear\n");
		}
	}
	else
	{
		printf("Alien\n");
	}


	return 0;
}