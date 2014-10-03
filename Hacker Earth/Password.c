#include<stdio.h>
#include<string.h>

int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		char pattern[1000];
		char string[100000];
		scanf("%s",pattern);
		scanf("%s",string);
		int m = strlen(pattern);
		int n = strlen(string);
		int p_count[26] = {0};
		int s_count[26] = {0};

		int i;
		for(i=0;i<m;i++)
		{
			p_count[pattern[i]-'a']++;
		}

		for(i=0;i<m;i++)
		{
			s_count[pattern[i]-'a']++;
		}

		int match=0;
		int k;
		for(i=m;i<n;i++)
		{
			int found = 1;
			
			for(k=0;k<26;k++)
			{
				if(p_count[k]!=s_count[k])
				{
					found  = 0;
					break;
				}
			}
			if(found)
			{
				match = 1;
				break;
			}

			s_count[pattern[i-m]-'a']--;
			s_count[pattern[i]-'a']++;

		}

		int found=1;
		for(k=0;k<26 && !match;k++)
		{
			if(p_count[k]!=s_count[k])
				{
					found  = 0;
					break;
				}
		}
		if(found==1)
		{
			match=1;
		}

		if(match==1)
		{
			printf("YES\n");
		}
		else
		{
			printf("NO\n");
		}

	}
	return 0;
}