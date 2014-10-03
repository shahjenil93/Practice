#include<stdio.h>
#include<stdlib.h>

int ThirdLargestElement(int arr[], int n);

int main()
{
	int arr[] = {60,40,20,90,50,30,80,70,10,70};
	int n  = sizeof(arr)/sizeof(arr[0]);
	int x = ThirdLargestElement(arr,n);
	printf("%d\n", x);
	return 0;
}

int ThirdLargestElement(int arr[], int n)
{
	int max1 = arr[0], max2=arr[0],max3=arr[0];
	int i;
	for(i=1;i<n;i++)
	{
		if(arr[i]>max1 && arr[i]>max2 && arr[i]>max3)
		{
			max3 = max2;
			max2= max1;
			max1 = arr[i];
		}

		else if(arr[i]< max1 && arr[i]>max2 && arr[i]>max3)
		{
			max3 = max2;
			max2 = arr[i];
		}

		else if(arr[i] < max1 && arr[i]<max2 && arr[i]>max3)
		{
			max3 = arr[i];
		}
	}
	return max3;
}