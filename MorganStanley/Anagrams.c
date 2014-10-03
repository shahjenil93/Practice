#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>

int main()
{
	char str1[100];
	char str2[100];
	//scanf("%[\^n]",str1);
	//scanf("%[\^n]",str2);
	gets(str1);
	gets(str2);
	int m  = strlen(str1);
	int n  = strlen(str2);
	printf("%d\n",n);
	int i;
	int count1[26];
	int count2[26];
	for(i=0;i<m;i++)
	{
		count1[str1[i]-'a']++;
	}
	for(i=0;i<n;i++)
	{
		count2[str2[i]-'a']++;
	}

	bool flag = true;
	for(i=0;i<26;i++)
	{
		if(count1[i]!=count2[i])
		{
			printf("NO\n");
			flag = false;
			break;
		}
	}
	if(flag==true)
	{
		printf("YES\n");
	}

}