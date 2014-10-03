#include<stdio.h>
 
long factorial(int);
long find_ncr(int, int);
 
int main()
{
	int t,i;
	scanf("%d",&t);
	
	for(i=0;i<t;i++)
	{
   int n, m;
   long ncr,denom;
 
  // printf("Enter the value of n and r\n");
   scanf("%d%d",&m,&n);
 
 if(n!=m)
 {
   ncr = find_ncr(m, n-m)*factorial(n);
   denom = factorial(n-m+1);
   ncr = (ncr/denom)%1000000007;
   
   printf("%ld\n",ncr);
  }
  else
  {
  	ncr  = factorial(n)%1000000007;
  	printf("%ld\n",ncr);
  } 
}
 
   return 0;
}
 
long find_ncr(int n, int r)
{
   long result;
 
   result = factorial(n)/(factorial(r)*factorial(n-r));
 
   return result;
}
 

 
long factorial(int n)
{
	if (n==0)
	{
		return 1;
	}
	{
		/* code */
	}
   int c;
   long result = 1;
 
   for( c = 1 ; c <= n ; c++ )
      result = result*c;
 
   return ( result );
}