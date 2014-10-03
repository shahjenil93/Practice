#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


int transaction(int arr[], int n, int left);


 int left = 0;
 int max = 0;
 int sum = 0;

 

int main() 
{
    int t;
    int n;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d",&n);
        int arr[n];
        int i;
        for(i=0;i<n;i++)
        {
            scanf("%d",&arr[i]);    
        }
       // printf("hello");
       
        int x = transaction(arr,n,0);
        printf("%d\n",x);
    }
       
    return 0;
}
    
    
int transaction(int arr[], int n, int left)
{
    int i;
    int max_ind = 0;
    if(left==n-1)
    {
     return sum;   
    }
    
        for(i=left;i<n;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                max_ind = i;
            }
        }
       
        for(i=left;arr[i]<=arr[max];i++)
        {
            printf("sum:%d",i);
            sum-=arr[i];  
        }
        sum = sum+2*arr[max];

        if(max_ind==n-1)
            return sum;
   
    return transaction(arr, n, max_ind+1);
}
