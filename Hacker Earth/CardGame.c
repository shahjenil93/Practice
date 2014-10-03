#include<stdio.h>
#include<math.h>

int main()
{
	int n;
	scanf("%d",&n);
	int arr[n];
	int i,j;
	for(i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}

	int win[n];
	float win_count = 0;
	float lose_count = 0;
	float win_prob, lose_prob ;
	for(i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{	
			if(arr[i]<arr[j])
			{
				lose_count++;
			}
			if(arr[i]>arr[j])
			{
				win_count++;
			}
		}	
	}

	//	printf("%f %f", win_count, lose_count);
		win_prob =  (win_count / ((n)*(n-1)));
		lose_prob = (lose_count / ((n)*(n-1)));
		printf("%f %f",win_prob,lose_prob);

}