#include<stdio.h>
#include<math.h>

float area(int x1,int y1, int x2, int y2, int x3, int y3);

struct point
{
	int x;
	int y;
};

int main()
{
	struct point p1,p2,p3,pp;
	scanf("%d %d",&p1.x,&p1.y);
	scanf("%d %d",&p2.x,&p2.y);
	scanf("%d %d",&p3.x,&p3.y);
	scanf("%d %d",&pp.x,&pp.y);

	if(area(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y)==(area(pp.x,pp.y,p2.x,p2.y,p3.x,p3.y)+area(p1.x,p1.y,pp.x,pp.y,p3.x,p3.y)+area(p1.x,p1.y,p2.x,p2.y,pp.x,pp.y)))
	{
		printf("YES\n");
	}
	else
	{
		printf("NO\n");
	}

}

float area(int x1,int y1, int x2, int y2, int x3, int y3)
{
	return abs(x1*(y2-y3) +(x2*(y3-y1)) + (x3*(y1-y2)))/2.0;
}