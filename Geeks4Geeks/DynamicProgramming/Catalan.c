#include<stdio.h>
#include<math.h>

int Catalan(int n);


int main()
{
	int n;
	scanf("%d",&n);
	int x = Catalan(n);
	printf("%d\n",x);
	return 0;
}

int Catalan(int n)
{

	int table[100];
	int i;
	int count = 0;
	
	if(n<=1)
		return 1;
	

	for(i=0;i<n;i++)
	{
		count += Catalan(i)*Catalan(n-i-1);
	}

	return count;
}