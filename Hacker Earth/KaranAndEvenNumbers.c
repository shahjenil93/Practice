#include<stdio.h>
#include<math.h>

int main()
{
	int flag = 1;
	while(flag)
	{
		int no;
		scanf("%d",&no);
		if(no==-1)
		{
			break;
		}
		if(no%2==0)
		{
			printf("%d\n",no);
		}
	}
	return 0;
}