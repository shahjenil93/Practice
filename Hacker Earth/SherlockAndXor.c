#include<stdio.h>
int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		long n;
		scanf("%d",&n);
		long arr[n];
		long i;
		for(i=0;i<n;i++)
		{
			scanf("%ld",&arr[i]);
		}

		long long int odd = 0;
		long long int even = 0;
		int count[1000];
		for(i=0;i<n;i++)
		{
			if(arr[i]%2==0)
			{
				even++;
			}
			else
			{
				odd++;
			}

		}
		// for(i=0;i<1000;i++)
		// {
		// 	count[i]=0;
		// }

		// for(i=0;i<n;i++)
		// {
		// 	count[arr[i]]++;	
		// }

		// for(i=0;i<1000;i++)
		// {
		// 	if(count[i]>0 && i%2==0)
		// 	{
		// 		even++;
		// 	}
		// 	else if(count[i]>0 && i%2==1)
		// 	{
		// 		odd++;
		// 	}
		// }
		long long int prod = odd*even;
		printf("%lld\n",prod);
	}
}