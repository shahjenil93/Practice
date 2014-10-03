#include<stdio.h>
#include<math.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		char matrix[n][n];
		int i=0;
		int j=0;
		for(i=0;i<n;i++)
		{
			char str[100];
			scanf("%s",str);
			for(j=0;j<n;j++)
			{
				matrix[i][j] = str[j];
			}	
		}

		j = n-1;
		int count=0;
		int k=0;
		for(j=n-1;j>=0;j--)
		{
			
			for(i=n-1;i>=0;i--)
			{
				 k = j;
				if(matrix[i][j]=='.')
				{
					while(k<n-1 && matrix[i][k]!='#')
					{
						k++;
					}
					if(k==n-1 && matrix[i][k]!='#')
					{
						k++;
					}
					if(k==n)
					{
						count++;
					}
				}
				else
				{
					break;
				}
			}
		}
		printf("%d\n",count);			
	}
	return 0;
}