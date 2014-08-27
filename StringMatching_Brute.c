#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main()
{
	char text[] = "she sells sea shdells on the sea shore";
	char string[] = "shell";
	int i,j, temp;
	for(i=0;i<strlen(text);i++)
	{
		temp = i;
		for(j=0;j<strlen(string);j++)
		{
			if(text[temp]==string[j])
			{
				temp++;

			}
			else
			{
				break;
			}
			if(j==strlen(string)-1)
			{
				printf("Yes");
			}
		}
		
		
	}
}