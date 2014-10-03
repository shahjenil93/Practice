#include<stdio.h>
#include<math.h>

int main()
{
	int n;
	scanf("%d",&n);
	int arr[n];
	int i;
	for(i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	int temp=arr[0];
	int min=100;
	int max=0;
	for(i=0;i<n-1;i++)
	{
		if(temp>arr[i])
		{
			temp = arr[i];
			//min = i;
		}
	}
	max = temp;

 	while(max--)
 	{
		temp = arr[0];
		for(i=0;i<n-1;i++)
		{
			if(temp<arr[i] && arr[i]>0)
			{
				temp = arr[i];
				min = i;
			}
		}
		arr[min]--;
		arr[min+1]--;
	}

	int flag = 0;
	for(i=0;i<n;i++)
	{
		if(arr[i]!=0)
		{
			printf("NO\n");
			flag = 1;
			break;
		}

	}
	if(flag==0)
	{
		printf("YES\n");
	}
	return 0;
}