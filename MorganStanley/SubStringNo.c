#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int subString(char str[], int n);

int main()
{
	char str[1024];
	scanf("%s",str);
	int n = strlen(str);
	int x = subString(str,n);
	printf("%d\n",x);
	return 0;
}

int subString(char str[], int n)
{
	
	int i;
	int count;
	for(i=1;i<n;i++)
	{
		int k=i-1;
		int j = i+1;
		count =0;
		while(k>0 && str[j] && str[j]==str[k])
		{
			count++;
			j++;
			k--;
		}

		k = i;
		j = i+1;
		while(k>0 && str[j] && str[j]==str[k])
		{
			count++;
			j++;
			k--;
		}
	}
	printf("%d\n",count);
	return count;
}