// #include<stdio.h>
// #include<stdlib.h>
// #include<math.h>

// int lcs[1024][1024];
// int lcslength(char str1[], int m, char str2[], int n);
// int max(int a, int b);


// int main()
// {
// 	char str1[] = "bdcaba";
// 	char str2[] = "abcbdab";
// 	int x = lcslength(str1,6,str2,7);
// 	printf("%d",x);
// }

// // int lcslength(char str1[], int m, char str2[], int n)
// // {
// // 	int i,j;
// // 	for( i=0;i<m;i++)
// // 	{
// // 		lcs[i][n]=0;
// // 	}

// // 	for(i=0;i<n;i++)
// // 	{
// // 		lcs[m][i]=0;
// // 	}

// // 	for(i=m-1;i>0;i--)
// // 	{
// // 		for(j=n-1;j>0;j--)
// // 		{
// // 			lcs[i][j] = lcs[i+1][j+1];
// // 			if(str1[i] == str2[j])
// // 				lcs[i][j]++;
// // 			if(lcs[i][j+1] >lcs[i][j])
// // 				lcs[i][j] = lcs[i][j+1];
// // 			if(lcs[i+1][j] > lcs[i][j])
// // 				lcs[i][j] = lcs[i+1][j];
// // 		}
// // 	}
// // 	return lcs[0][0];
// // }

// int max(int a, int b)
// {
//     return (a > b)? a : b;
// }


// int lcslength(char str1[], int m, char str2[], int n)
// {
// 	int i,j;
// 	for( i=0;i<m;i++)
// 	{
// 		lcs[i][n]=0;
// 	}

// 	for(i=0;i<n;i++)
// 	{
// 		lcs[m][i]=0;
// 	}

// 	for(i=m-1;i>0;i--)
// 	{
// 		for(j=n-1;j>0;j--)
// 		{
			
// 			if(str1[i] == str2[j])
// 				lcs[i][j]++;
// 			else
// 			{
// 				lcs[i][j] = max(lcs[i+1][j],lcs[i][j+1]);
// 			}
// 		}
// 	}
// 	return lcs[0][0];
// }



#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int max(int a, int b);
  
/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
int lcs( char *X, char *Y, int m, int n )
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
  
/* Utility function to get max of 2 integers */
int max(int a, int b)
{
    return (a > b)? a : b;
}
  
/* Driver program to test above function */
int main()
{
  char X[] = "AGGTAB";
  char Y[] = "GXTXAYB";
  
  int m = strlen(X);
  int n = strlen(Y);
  
  printf("Length of LCS is %d\n", lcs( X, Y, m, n ) );
  
  getchar();
  return 0;
}