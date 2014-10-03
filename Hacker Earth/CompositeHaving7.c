#include<stdio.h>
#include<math.h>
#include<stdbool.h>


bool isComposite(int n);
bool hasSeven(int n);

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int start, end;
		scanf("%d %d",&start, &end);
		int i;
		int count=0;
		for(i=start;i<end;i++)
		{
			if(isComposite(i) && hasSeven(i))
			{
				count++;
			}
		}
		if(count==0)
		{
			printf("-1\n");
		}
		else
		{
			printf("%d\n",count);
		}
	}	
}

bool isComposite(int n)
{
	int i;
	for(i=2;i<sqrt(n);i++)
	{
		if(n%i==0)
		{
			return true;
		}
	}
	return false;
}

bool hasSeven(int n)
{
	int arr[10];
	int i=0;
	while(n>0)
	{
		arr[i] = n%10;
		n = n/10;
		i++;
	}
	for(i=0;i<10;i++)
	{
		if(arr[i]==7)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	return false;
}