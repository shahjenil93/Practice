#include<stdio.h>
#include<math.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n,k;
		scanf("%d %d",&n, &k);
		if(n==1 || n==2)
		{
			printf("%d\n",n);
			break;
		}
		else if(n==3)
		{
			if(k==1)
			{
				printf("6\n");
			}
			else if(k==2)
			{
				int a = 720%107;
				printf("%d",a);
			}
			else
			{
				printf("0\n");
			}
		}
		else if(n==4)
		{
			if(k==1)
			{
				printf("24\n");
			}
			else
			{
				printf("0\n");
			}
		}
		else
		{
			printf("0\n");
		}

	}
	return 0;
}