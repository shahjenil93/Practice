#include<stdio.h>
extern int yylex();
int main()
{
	int a = yylex();
}
