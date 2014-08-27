import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.*;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


class StoreCredit 
{
	public static void main(String[] args) throws IOException
	{
		File text = new File("/Users/jenil/Documents/Programming/Practice/GoogleCodeJam/A-large-practice.in.txt");
		File outFile = new File ("output1.txt");
	   
	    PrintWriter pWriter = new PrintWriter (outFile);
		Scanner sc = new Scanner(text);
		int t = sc.nextInt();
		for(int f=0;f<t;f++)
		{
			int c = sc.nextInt();
			int i = sc.nextInt();
			int price[] = new int[i];
			int arr[] = new int[i];
			for(int j =0;j<price.length;j++)
			{
				price[j] = sc.nextInt();
				arr[j] = price[j];
			}
			Arrays.sort(price);
			int x=0;
			int y = price.length-1;
			while(y>=x)
			{
				if(price[x]+price[y]==c)
				{
				//	System.out.println((x+1)+" "+(y+1));
					break;
				}
					else if(price[x]+price[y]>c)
				{
					y--;
				}
				else
				{
					x++;
				}
			}
			int m,n;
			for(m=0;m<arr.length;m++)
			{
				if(arr[m]==price[x])
				{
					arr[m]=0;
					break;
				}
			}
			for(n=0;n<arr.length;n++)
			{
				if(arr[n]==price[y])
					break;
			}
			pWriter.write("Case #"+(f+1)+": ");
			pWriter.write((Math.min(m,n)+1)+ " "+ (Math.max(m, n)+1));
			pWriter.println();
			pWriter.flush();
		}
	}
}
