#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int EditDistanceDP(char str1[], char str2[], int m, int n);

int min(int a, int b) {
   return a < b ? a : b;
}
 
// Returns Minimum among a, b, c
int Minimum(int a, int b, int c)
{
    return min(min(a, b), c);
}

int main()
{
	char str1[10];
	char str2[20];
	scanf("%s",str1);
	scanf("%s",str2);
	int m = strlen(str1)+1;
	int n = strlen(str2)+1;
	int x= EditDistanceDP(str1,str2,m,n);
	printf("%d\n",x);
	return 0;
}

int EditDistanceDP(char str1[], char str2[], int m, int n)
{
	int i,j;
	int table[m+1][n+1];

	for(i=0;i<m;i++)
		table[i][0] = i;
	for(j=0;j<n;j++)
		table[0][j] = j;

	for(i=1;i<=m;i++)
	{
		for(j=1;j<=n;j++)
		{
			int m = min(table[i-1][j], table[i][j-1])+1;
			table[i][j] = min(m, table[i-1][j-1] + (str1[i-1]==str2[j-1] ? 0:1));
		}
	}
	return table[m][n];
}