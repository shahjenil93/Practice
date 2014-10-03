#include<stdio.h>
#include<math.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}

int main()
{
	int n;
	scanf("%d",&n);
	int digits[10];
	int i=0;
	int temp;
	int dig_count=1;
	while(n>0)
	{
		temp = n%10;
		digits[i] = temp;
		i++;
		n = n/10; 
		dig_count++;
	}

	for(i=dig_count-2;i>=0;i--)
	{
		printf("%d ",digits[i]);
	}

	


}