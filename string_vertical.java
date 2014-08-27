import java.util.Scanner;
class string_vertical
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		int i,j=0;
		//String[] scopy = new String[s.length()];
		for(i=0;i<s.length();i++)
		{
			//scopy.charAt(i)=s.charAt[i];
			j=i;
			for(;j<n;j+=n)
			{
				if(s.charAt(j)!=null)
				{
				System.out.println(s.charAt(j));
				s.charAt(j)=null;
				}
			}
			System.out.println();
		}

	}
}