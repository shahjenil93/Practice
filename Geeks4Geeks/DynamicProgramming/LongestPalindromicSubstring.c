#include <stdio.h>
#include <string.h>
#include <stdbool.h>


int longestPalSubstr(char *str)
{
	int n = strlen(str);
	int i;
	bool table[n+1][n+1];
	memset(table,0,sizeof(table));

	for(i=0;i<n;++i)
	{
		table[i][i] = true;
	}

	int start = 0;
	int maxlength = 1;
	for(i=0;i<n;++i)
	{
		if(table[i][i] == table[i][i+1])
		{
			start = i;
			maxlength = 2;
			table[i][i] = true;
		}
	}

	int k;
	for(k=3;k<=n;k++)
	{
		for(i=0;i<n-k+1;i++)
		{
			int j = i + k -1;

			if(str[i] == str[j] && table[i+1][j-1])
			{
				table[i][j] = true;
				if(k>maxlength)
				{
					maxlength = k;
					start = i;
				}
			}
		}
	}

	return maxlength;
}

int main()
{
	char str[100], str2[100];
	scanf("%s",str);
	int i;
	int n = strlen(str);
	for(i=0;i<n;i++)
	{
	//	printf("%c ",str[i]);
		str2[i] = str[i];
	}
	int x = longestPalSubstr(str2);
	printf("%d\n",x);
	return 0;
}