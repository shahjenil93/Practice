#include<stdio.h>
#include<stdlib.h>

int max (int x, int y) {return x > y? x : y; }

int main()
{
	int arr[] = {1,-2,-3,0,7,-8,-2}
	int n = sizeof(arr)/sizeof(arr[0]);
	maxSubProduct(arr,n);
	return 0;
}

int maxSubProduct(int arr[], int n)
{
	int i,j;
	int product=0;
	int max_product;
	int min_product;

	for(i=0;i<n;i++)
	{
		if(arr[i]==0)
		{
			max_product=0;
			min_product=0;
		}
		else if(arr[i]>0)
		{
			max_product = max_product*arr[i];
			if(min_product*arr[i]>1)
			{
				min_product = 1
			}
			else
			{
				min_product = min_product * arr[i];
			}
		}
		else
		{
			int temp = max_product;
			max_product = max(min_product*arr[i],1);
			min_product = temp * arr[i];
		}

		if(product<max_product)
		{
			product = max_product;
		}
	}
	return product;
}