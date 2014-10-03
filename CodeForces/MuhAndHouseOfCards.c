#include<stdio.h>
#include<math.h>
#include<stdlib.h>

int main()
{
	unsigned long int n;
	scanf("%lu",&n);
	unsigned long int arr[n+1];
	unsigned long int start = 2;
	unsigned  long int i=2;
	unsigned  long int j=3;
	unsigned  long int d = 0;
	unsigned  long int e=5;
	for(i=0;i<=n;i++)
		arr[i] = 0;

	for(i=2;i<=n;i=i+d)
	{
		for(j=0;i+j<=n;j=j+3)
		{
			arr[i+j]++;
		}
		d = d + e;
		e = e +3;
	} 
	printf("%lu",arr[n]);
	return 0;
}