#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		int arr[n];
		int i;
		for(i=0;i<n;i++)
		{
			scanf("%d",&arr[i]);
		}

		int min = arr[0];
		for(i=0;i<n;i++)
		{
			if(arr[i]<min)
			{
				min = arr[i];
			}
		}

		int j;
		int flag = 1;
		int gcd =1;
		for(j=2;j<=ceil(sqrt(min));j++)
		{
			//printf("hello");
			for(i=0;i<n;i++)
			{
				if(arr[i]%j==0)
				{
					flag = 1;
					continue;
				}
				else
				{	
					flag = 0;
					break;
				}
			}
			if(flag==1)
			{
				gcd = j;
				break;
			}
		}
		//printf("%d\n",gcd);
		if(flag==1 && gcd!=1)
		{
			printf("-1\n");
		}
		else
		{
			printf("%d\n",n);
		}
	}
}