import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ReverseWords 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File text = new File("/Users/jenil/Documents/Programming/Practice/GoogleCodeJam/B-small-practice.in.txt");
		File outFile = new File ("output.txt");
	    PrintWriter pWriter = new PrintWriter (outFile);
		Scanner sc = new Scanner(text);
		int t = sc.nextInt();
		sc.nextLine();
		for(int f=0;f<t;f++)
		{
			pWriter.write(f);
			pWriter.flush();
			pWriter.write("Case #"+(f+1)+": ");
			pWriter.flush();
			String st = sc.nextLine();
			String[] words = st.split(" ");
			for(int i=words.length-1;i>=0;i--)
			{
				pWriter.write(words[i]+" ");
				pWriter.flush();
			}
			pWriter.println();
			pWriter.flush();
		}
	}
}
