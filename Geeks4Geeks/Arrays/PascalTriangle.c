#include<stdio.h>
#include<math.h>

long long C(int n, int r);

int main()
{
	long long n,r;
	scanf("%lld %lld",&n,&r);
	long long x = C(n,r);
	printf("%lld\n",x);
}

// long long C(int n, int r)
// {
// 	long long triangle[n][n];
// 	triangle[0][0] = 1;
// 	int i,j;
// 	for(i=0;i<n;i++)
// 	{
// 		triangle[i][0] = 1;
// 		for(j=0;j<=i;j++)
// 		{
// 			triangle[i][j] = triangle[i-1][j-1] +  triangle[i-1][j];
// 		}
// 	}
	
// 	return triangle[n][r];
// }

# define MAX 100 // assuming we need first 100 rows
long long triangle[MAX + 1][MAX + 1];

void makeTriangle() {
    int i, j;

    // initialize the first row
    triangle[0][0] = 1; // C(0, 0) = 1

    for(i = 1; i < MAX; i++) {
        triangle[i][0] = 1; // C(i, 0) = 1
        for(j = 1; j <= i; j++) {
            triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
    }
}

long long C(int n, int r) {
    return triangle[n][r];
}