#include<stdio.h>
#include<math.h>

int main()
{
	unsigned long long t,test;
	scanf("%llu",&t);
	for(test=0;test<t;test++)
	{
		unsigned long long start,end,hops;
		scanf("%llu %llu %llu",&start, &end, &hops);
		unsigned long long i;
		unsigned long long count=0;
		count = ceil(end/hops) - (start/hops);
		if(start%hops==0)
		{
			count = count+1;
		}
		printf("%llu\n",count);

	}
	return 0;
}