#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	int t;
	scanf("%d",&t);
	int test;
	for(test=0;test<t;test++)
	{
		int n;
		scanf("%d",&n);
		int arr[200];
		arr[0]=1;
		int count = 0;
		int index =0;
		int j,i;
		for(j=n;j>=2;j--)
		{
			int temp = 0;
			for(i=0;i<=index;i++)
			{
				temp = (arr[i]*j)+temp;
				arr[i] = temp%10;
				temp = temp/10;
			}

			while(temp>0)
			{
	    	    arr[++index]=temp%10;    
        		temp=temp/10;
        	}
    
		}

		for(i=index;i>=0;i--)
   		{
    		if(arr[i]==4 || arr[i]==7)
    		{
    			count++;
    		}
		}
		printf("%d\n",count);

	}
	return 0;
}