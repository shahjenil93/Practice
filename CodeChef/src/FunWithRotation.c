#include<stdio.h>
#include<stdlib.h>

int main()
{
	int n,m;
	scanf("%d %d",&n,&m);
	int arr[n+2];
	int f;
	for(f=0;f<n;f++)
	{
		scanf("%d",&arr[f]);
	}


	int shift =0;
	int e;
	for(e=0;e<m;e++)
	{
		char code;
		int d;
		scanf(" %c %d",&code,&d);

		if(code=='R')
		{
			printf("%d\n",arr[(((shift+d-1)%n)+n)%n]);
		}

		if(code=='C')
		{
			shift = (((shift + d)%n)+n)%n;
		}

		if(code=='A')
		{
			shift = (((shift-d)%n)+n)%n;
		}
	}
	return 0;
}