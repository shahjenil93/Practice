#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main()
{
	int t;
	scanf("%d",&t);
	int e;
	char website[1024];
	for(e=0;e<t;e++)
	{
		int new = 0;
		int old = 0;
		scanf("%s",website);
		int i=0;
		int n = strlen(website);
		int state = 1;
		for(;i<n;i++)
		{
			while(website[i]!='.' && state==1)
			{
				old++;
				i++;
//				continue;
			}
			state = 2;

			if(website[i]=='a' || website[i]=='e' || website[i]=='i' || website[i]=='o' || website[i]=='u' )
			{
				old++;
			}
			else
			{
				old++;
				new++;
			}

		}

		printf("%d",new);
		printf("/");
		printf("%d\n",old);
	}
	return 0;
}