import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class T9 
{
	public static void main(String[] args) throws IOException
	{
		char a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
		a=2;
		b=22;
		c=222;
		d=3;e=33;f=333;
		g=4;h=44;i=444;
		j=5;k=55;l=555;
		m=6;n=66;o=666;
		p=7;q=77;r=777;s=7777;
		t=8;u=88;v=888;
		w=9;x=99;y=999;z=9999;
		FileReader fr;
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int tcount=0;tcount<test;tcount++)
		{
			String str = sc.nextLine();
			for(int counter=0;counter<str.length();counter++)
			{
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==b)
					System.out.print("22");
				if(str.charAt(counter)==c)
					System.out.print("222");
				if(str.charAt(counter)==d)
					System.out.print("3");
				if(str.charAt(counter)==e)
					System.out.print("33");
				if(str.charAt(counter)==f)
					System.out.print("333");
				if(str.charAt(counter)==g)
					System.out.print("4");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				if(str.charAt(counter)==a)
					System.out.print("2");
				
				if(str.charAt(counter)==a)
					System.out.print(2);
				if(str.charAt(counter)==a)
					System.out.print(2);
				if(str.charAt(counter)==a)
					System.out.print(2);
				if(str.charAt(counter)==a)
					System.out.print(2);
				if(str.charAt(counter)==a)
					System.out.print(2);
				
			}
		}
	}
}
