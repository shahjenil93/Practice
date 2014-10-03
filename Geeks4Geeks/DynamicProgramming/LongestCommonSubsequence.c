#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int longestCommonSubsequence(char str1[], int m, char str2[], int n);
int lcs( char *X, int m, char *Y, int n );


int max(int a, int b)
{
	if(a>b)
		return a;
	else
		return b;
}

int LCS[100][100];


int main()
{
	char str1[100], str2[100];
	scanf("%s",str1);
	scanf("%s",str2);
	int m = strlen(str1);
	int n = strlen(str2);

	int x =	longestCommonSubsequence(str1,m,str2,n);
	printf("%d\n",x);
	return 0;	
}

int longestCommonSubsequence(char *str1, int m, char *str2, int n)
{
	//printf("hello");
	int i,j;
	for(i=0;i<=m;i++)
	{
		LCS[i][m]=0;
	}
	for(i=0;i<=n;i++)
	{
		LCS[n][i]=0;
	}

	for(i=m-1;i>=0;i--)
	{
		//printf("hello1");
		for(j=n-1;j>0;j--)
		{
		//	printf("hello2");
			
			if(str1[i]==str2[j])
			{
				//printf("hello");
				LCS[i][j] = LCS[i+1][j+1] + 1;
			}

			if(LCS[i+1][j]>LCS[i][j])
			{
				LCS[i][j] = LCS[i+1][j];
			}
			if(LCS[i][j+1]>LCS[i][j])
			{
				LCS[i][j] = LCS[i][j+1];
			}
			//LCS[i][j] = max(LCS[i+1][j], LCS[i][j+1]);
		}
	}
	printf("%d\n",LCS[0][0]);
	return LCS[0][0];
}

int lcs( char *X, int m, char *Y, int n )
{
   int L[m+1][n+1];
   int i, j;
  
   /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
   for (i=0; i<=m; i++)
   {
     for (j=0; j<=n; j++)
     {
       if (i == 0 || j == 0)
         L[i][j] = 0;
  
       else if (X[i-1] == Y[j-1])
         L[i][j] = L[i-1][j-1] + 1;
  
       else
         L[i][j] = max(L[i-1][j], L[i][j-1]);
     }
   }
    
   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
   return L[m][n];
}