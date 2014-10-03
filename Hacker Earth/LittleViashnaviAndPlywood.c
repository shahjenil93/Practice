#include<stdio.h>
#include<math.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int arr[5];
		int m,k;
		scanf("%d %d",&m,&k);
		if(m==1)
		{
			printf("%d\n",8*k);
		}
		else if(m==2)
		{
			if(k%2==0)
			{
				printf("%d\n",(4*k)+1);
			}
			else
			{
				printf("%d\n",(4*k)+3);
			}
		}
		else if(m==3)
		{
				printf("%d\n",(4*k)+2);	
		}
		else if(m==4)
		{
			if(k%2==0)
			{
				printf("%d\n",(4*k)+3);
			}
			else
			{
				printf("%d\n",(4*k)+1);
			}
		}
		else
		{
			printf("%d\n",(8*k)+4);
		}
	}
	return 0;
}