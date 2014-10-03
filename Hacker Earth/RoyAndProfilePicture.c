#include<stdio.h>

int main()
{
	int l,n,w,h;
	scanf("%d",&l);
	scanf("%d",&n);
	while(n--)
	{
		scanf("%d %d",&w, &h);
		if(h>=l && w>=l && h==w)
		{
			printf("ACCEPTED\n");
		}
		else if(h>l && w>l && h!=w)
		{
			printf("CROP IT\n");
		} 
		else if((h==l && w>l) || (h>l && w==l))
		{
			printf("CROP IT\n");
		} 
		else
		{
			printf("UPLOAD ANOTHER\n");
		}
	}
	return 0;
}