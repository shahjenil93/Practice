#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void shuffle(int arr[], int n);
void swap(int *a, int *b);

int main()
{
	int arr[] = {1,2,3,4,5,6,7,8};
	int n = sizeof(arr)/sizeof(arr[0]);
	shuffle(arr,n);
	int i;
	for(i=0;i<n;i++)
	{
		printf("%d\t",arr[i]);
	}

}

void shuffle(int arr[], int n)
{
	int i,j;
	for(i=n-1;i>0;i--)
	{
		j = rand() % i ;
		swap(&arr[i], &arr[j]);

	}
}

void swap(int *a, int *b)
{
	int temp =0;
	temp = *a;
	*a = *b;
	*b = temp;
}

