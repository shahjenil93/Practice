#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void permutation(char string[], int k, int n)
{
	if(k==n)
	{
		int i;
		for(i=0;i<strlen(string);i++)
		{
			printf("%c",string[i]);
		}
		printf("\n");
	}
	else
	{
		int i;
		char temp;
		for(i=k;i<n;i++)
		{
			temp = string[k];
			string[k] = string[i];
			string[i] = temp;
			permutation(string,k+1,n);
			temp = string[k];
			string[k] = string[i];
			string[i] = temp;
		}
	}
}

int main()
{
	char string[] = "bat";
	permutation(string,0,3);
}