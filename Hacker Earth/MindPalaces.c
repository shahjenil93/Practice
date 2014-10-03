#include<stdio.h>

int main()
{
	 int x,y;
	int i,j,k;
	scanf("%d %d",&x,&y);
	int matrix[x][y];
	for(i=0;i<x;i++)
	{
		for(j=0;j<x;j++)
		{
			scanf("%d",&matrix[i][j]);
		}
	}
	int q;
	scanf("%d",&q);
	while(q--)
	{
		int val;
		scanf("%d",&val);
		i=x-1;
		j=0;
		int true = 0;
		int i = 0, j = y-1;  //set indexes for top right element
   		while ( i < x && j >= 0 )
   		{
      		if ( matrix[i][j] == val )
      		{
      			true = 1;
         		printf("%d %d\n", i, j);
         	//	puts("%d", i);
         		break;
         		
      		}
      		
      		if ( matrix[i][j] > val )
        		j--;
      		else //  if mat[i][j] < x
        		i++;
   		}
 
   
		if(true==0)
			puts("-1 -1\n");
	}
	return 0;
}

