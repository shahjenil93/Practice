import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class BlackHorse
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File text = new File("/Users/jenil/Documents/Programming/Practice/GoogleCodeJam/ChinaQualification/BlackHorseSmall.txt");
		File outFile = new File ("BlackHorse1.txt");  
	    PrintWriter pWriter = new PrintWriter (outFile);
		Scanner sc = new Scanner(text);
		int t = sc.nextInt();
		for(int f=0;f<t;f++)
		{
			int n = sc.nextInt();
			Boolean evil = false;
			int h;
			String[] g1 = new String[n];
			for(int i=0;i<g1.length;i++)
				g1[i]=(String.valueOf(0));
			
			String[] g2 = new String[n];
			for(int i=0;i<g2.length;i++)
				g2[i]=(String.valueOf(0));
			
			int i=0,j=0;
			for(h=0;h<n;h++)
			{
			String t1 = sc.next();
			String t2 = sc.next();
			BlackHorse bh = new BlackHorse();
			if((bh.isPresent(t1, g1)==false && bh.isPresent(t1, g2)==false ) && (bh.isPresent(t2, g1)==false && bh.isPresent(t2, g2)==false))
			{
				g1[i]=t1;
				i++;
				g2[j]=t2;
				j++;
			}
			else if((bh.isPresent(t1, g1)==true && bh.isPresent(t2, g1)==true ) || (bh.isPresent(t1, g2)==true && bh.isPresent(t2, g2)==true))
			{
				evil = true;
			}
			else if((bh.isPresent(t1, g1)==true && bh.isPresent(t1, g2)==false ) || (bh.isPresent(t2, g1)==false && bh.isPresent(t2, g2)==true))
			{
				g1[i]=t1;
				i++;
				g2[j]=t2;
				j++;
			}
			else if((bh.isPresent(t1, g1)==false && bh.isPresent(t1, g2)==true ) || (bh.isPresent(t2, g1)==true && bh.isPresent(t2, g2)==false))
			{
				g1[i]=t2;
				i++;
				g2[j]=t1;
				j++;
			}
			
		}
			pWriter.write("Case #"+(f+1)+": ");
			if(evil==true)
				pWriter.println("YES");
			else
				pWriter.println("NO");
			pWriter.flush();
		}
	}
	
	boolean isPresent(String t1, String g1[])
	{
		for(int i=0;i<g1.length;i++)
		{
			if(g1[i].equals(t1))
				return true;
		}
		return false;	
	}
}
