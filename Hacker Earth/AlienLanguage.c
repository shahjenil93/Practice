#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char cmpfunc (const void * a, const void * b)
{
   return ( *(char*)a - *(char*)b );
}

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		char str1[100], str2[100];
		scanf("%s",str1);	
		scanf("%s",str2);	
		int n = strlen(str1);
		int m = strlen(str2);
		//printf("%d %d",n,m);
		int flag = 0;
		int for_break = 0;
		int i=0,j;
		// for(i=0;i<n;i++)
		// {
		// 	for(j=0;j<m;j++)
		// 	{
		// 		if(str1[j]==str2[j])
		// 		{
		// 			printf("YES\n");
		// 			flag =1;
		// 			for_break = 1;
		// 			break;
		// 		}
		// 	}
		// 	if(for_break==1)
		// 	{
		// 		break;
		// 	}
		// }
		// if(flag==0)
		// {
		// 	printf("NO\n");
		// }
		qsort(str1,n, sizeof(str1[0]), cmpfunc);
		qsort(str2,m, sizeof(str2[0]), cmpfunc);
		//printf("%s\n",str1);
		//printf("%s\n",str2);
		i=0;
		j=0;
		while(i<n && j<m)
		{
			if(str1[i]==str2[j])
			{
				printf("YES\n");
				flag =1;
				break;
			}
			else if(str1[i]<str2[j])
			{
				i++;
			}
			else
			{
				j++;
			}
		}
		if(flag==0)
		{
			printf("NO\n");
		}

	}

	return 0;

}