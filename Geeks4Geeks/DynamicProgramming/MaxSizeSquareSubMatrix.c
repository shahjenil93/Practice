#include<stdio.h>
#include<stdlib.h>

int maxSizeSubMatrix(int matrix[][] ,int m, int n);


int min(int a, int b, int c)
{
  int m = a;
  if (m > b) 
    m = b;
  if (m > c) 
    m = c;
  return m;
}

int main()
{
	int matrix[][] = { {0,1,1,0,1},{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1},{0,0,0,0,0}};
	int n = sizeof(matrix)/sizeof(matrix[0]);
	printf("%d\n",n);
	int m = sizeof(matrix)/sizeof(matrix[0][0]);
	printf("%d\n",m);
	int x = maxSizeSubMatrix(matrix,m,n);
	printf("%d\n",x);
	return 0;
}

int maxSizeSubMatrix(int matrix[][] ,int m, int n)
{
	int mat[n][m];
	int i,j;
	for(i=0;i<n;i++)
	{
		mat[i][0] = matrix[i][0];
	}

	for(i=0;i<m;i++)
	{
		mat[0][i] = matrix[0][i];
	}

	for(i=1;i<n;i++)
	{
		for(j=1;j<m;j++)
		{
			if(matrix[i][j]==1)
			{
				mat[i][j] = min(mat[i-1][j], mat[i-1][j-1], mat[i][j-1]) + 1;
			}
			else
			{
				mat[i][j]=0;
			}		
		}
	}

	int maxofs = matrix[0][0];
	int max_i =0;
	int max_j = 0;
	for(i=0;i<n;i++)
	{
		for(j=0;j<m;j++)
		{
			if(mat[i][j] >  maxofs)
			{
				maxofs = mat[i][j];
				max_j = j;
				max_i = i;
			}
		}
	}

	return maxofs;
}