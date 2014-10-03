#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{

	char str[100];
	scanf("%s",str);
	int count[26];
	int n = strlen(str);
	int i;
	int current;
	char *s = &str[0];
	for(i=0;i<26;i++)
	{
		count[i]=0;
	}
	for(i=0;i<n;i++)
	{
		current = str[i];
		//printf("ascii values: %d",current-97);
		count[current-97]++; 
	}

	bool flag = false;
	for(i=0;i<26;i++)
	{
		//printf("%d ",count[i]);
		if(count[i]==0)
		{
			flag = true;
			printf("NO\n");
			break;
		} 
	}
	if(flag == false)
	{
		printf("YES\n");
	}

}

}