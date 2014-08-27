import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class SimpleEditor 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<t;i++)
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String query = br.readLine();
			String[] splitStrings = query.split(" ");
			String s = splitStrings[2];
			String code = splitStrings[0];
			int pos = Integer.parseInt(splitStrings[1]);
			if(code.equalsIgnoreCase("+"))
			{
				sb.insert(pos, s);
			}
			else if(code.equalsIgnoreCase("?"))
			{
				System.out.println(sb.substring(pos-1, pos+Integer.parseInt(s)-1));
			}
			
		}
	}
}
