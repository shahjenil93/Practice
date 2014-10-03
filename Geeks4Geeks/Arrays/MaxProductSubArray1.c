#include<stdio.h>
#include<math.h>
#include<stdlib.h>

int max(int a, int b)
{
	if(a>=b) return a;
	else return b;
}

int min(int a, int b)
{
	if(a>=b) return b;
	else return a;
}

int main()
{
	int arr[] =  {2,1,-2,3,-5,-2,5,1,0,7};
	int n = sizeof(arr)/sizeof(arr[0]);
	int i;
	int max_ending_here= 1;
	int min_ending_here = 1;
	int overall_max = 1;
	
	for(i=0;i<n;i++)
	{
		if(arr[i]>0)
		{
			max_ending_here = max_ending_here * arr[i];
			min_ending_here = min(min_ending_here*arr[i],1);
		}

		else if(arr[i]==0)
		{
			max_ending_here = 1;
			min_ending_here = 1;
		}

		else
		{
			int temp = max_ending_here;
			max_ending_here = max(min_ending_here*arr[i],1);
			min_ending_here = temp * arr[i];
		}

		if(overall_max < max_ending_here)
		{
			overall_max = max_ending_here;
		}
	}
	printf("%d\n",overall_max);
	return 0;

}

