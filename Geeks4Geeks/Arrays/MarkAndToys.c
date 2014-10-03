#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}


int main() {
    int n, k, i, count;
    scanf("%d%d", &n, &k);
    long long *prices = (long long *)malloc(sizeof(long long)*n);
    for(i=0; i<n; i++) {
        scanf("%lld", &prices[i]);
    }
     
   
    int answer = 0;
    long long sum = 0;
    // Compute the answer
    qsort(prices,n, sizeof(prices[0]), cmpfunc);
    for(i=0;i<n;i++)
        printf("%llu ",prices[i]);
    
    for(i=0;i<n;i++)
    {
        if(sum>k)
        {
            break;    
        }
        sum += prices[i];
        answer++;
    }
    printf("%d\n", answer);
      
    return 0;
}
