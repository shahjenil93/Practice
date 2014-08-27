O	[0-7]
D	[0-9]
NZ	[1-9]
L	[a-zA-Z_]
A	[a-zA-Z_0-9]
H	[a-fA-F0-9]
HP	(0[xX])
E	([Ee][+-]?{D}+)
FS	(f|F|l|L)
IS	(((u|U)(l|L|ll|LL)?)|((l|L|ll|LL)(u|U)?))
CP	(u|U|L)
SP	(u8|u|U|L)
ES	(\\(['"\?\\abfnrtv]|[0-7]{1,3}|x[a-fA-F0-9]+))
WS	[ \t\v\n\f]



%{
#include <stdio.h>
#include<string.h>
void copy_file();
void print_struct();
%}


%option noyywrap

%%
"/*"		{ /* comment(); */ }
"//".*		{ /* do nothing */ }

"auto"		{ ; }
"break"		{ ; }
"case"		{ ; }
"char"		{ ; }
"const"		{ ; }
"continue"	{ ; }
"default"	{ ; }
"do"		{ ; }
"double"	{ ; }
"else"		{ ; }
"enum"		{ ; }
"extern"	{ ; }
"float"		{ ; }
"for"		{ ; }
"goto"		{ ; }
"if"		{ ; }
"inline"	{ ; }
"int"		{ ; }
"long"		{ ; }
"register"	{ ; }
"restrict"	{ ; }
"return"	{ ; }
"short"		{ ; }
"signed"	{ ; }
"sizeof"	{ ; }
"static"	{ ; }
"struct"	{ ; }
"switch"	{ ; }
"typedef"	{ ; }
"union"		{ ; }
"unsigned"	{ ; }
"void"		{ ; }
"volatile"	{ ; }
"while"		{ ; }

{HP}{H}+{IS}?			{ print_struct(yytext); /* Hexadecimal */}
{NZ}{D}*{IS}?			{  print_struct(yytext); }
"0"{O}*{IS}?			{ print_struct(yytext);}
{CP}?"'"([^'\\\n]|{ES})+"'"	{  print_struct(yytext);}

{D}+{E}{FS}?			{print_struct(yytext); /*float*?}
{D}*"."{D}+{E}?{FS}?		{ 	print_struct(yytext); }
{D}+"."{E}?{FS}?		{ 	print_struct(yytext);}

({SP}?\"([^"\\\n]|{ES})*\"{WS}*)+	{ 	print_struct(yytext); /*string*/}

{L}+{A}* { printf("%s\n",yytext); print_struct(yytext); /*variable*/}


{WS}		{ /* whitespace */ }
.		{ /* ignore rest */}

%%

void copy_file(){
   FILE *fp1, *fp2;
   char ch;
   fp1 = fopen("outfinal.txt", "r");
   fp2 = fopen("out.txt", "w");

   while (1)
   {
      ch = fgetc(fp1);
 
      if (ch == EOF)
         break;
      else
         putc(ch, fp2);
   }

   fclose(fp1);
   fclose(fp2);

}

void do_nothing()
{
	 return;
}

void print_struct(char lit[])
{
	char p[20];
	int chk=0,count;
	long offset; 
	FILE *fp=fopen("out.txt","a+");
	FILE *ft=fopen("outfinal.txt","w+");
	fseek( fp,0, SEEK_SET );

	while(fscanf(fp, "%s %d", p, &count) == 2)
	{
		if(strcmp(p,lit)==0)
		{
	 		fprintf(ft,"%s %d\n",p,++count);
	 		chk=1;
		}

		if(chk==1)
		{
			chk=-1;
		}
		else
			fprintf(ft,"%s %d\n",p,count);
	}

	if(chk!=-1)
	{
		 fprintf(ft,"%s %d\n",lit,1);
	}

	fclose(ft);
	fclose(fp);
	copy_file();
}

int main(int argc,char* argv[]) 
{
  yyin=fopen(argv[1],"r");
  yylex(); 
  return 1;
}

