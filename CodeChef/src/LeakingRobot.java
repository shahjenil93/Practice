import java.util.Scanner;


public class LeakingRobot 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		for(long q=0;q<t;q++)
		{
			long xt = sc.nextLong();
			//System.out.println(xt);
			long yt = sc.nextLong();
			int i=1;
			
			if(xt>=0 && yt>=0)
			{
				if((xt%2==1 && yt<=xt+1) || (yt%2==0 && xt<=yt-1))
				{
					System.out.println("YES");
				}
				else
				{
					if(xt==0 && yt==0)
					{
						System.out.println("YES");
					}
					else
					{
						System.out.println("NO");
					}
					
				}
			}

			if(xt<0 && yt >0)
			{
				if(((Math.abs(xt)%2==0)&& yt<=Math.abs(xt)) || ((Math.abs(yt)%2==0) && Math.abs(xt)<=yt)) 
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}			
			
			if(xt<0 && yt<=0)
			{
				if(((Math.abs(xt)%2==0) && yt>=xt) || (Math.abs(yt)%2==0 && xt>=yt))
				{
					
						System.out.println("YES");
				}	
					else
					{
						System.out.println("NO");
					}
				}
			
			
			if(xt>=0 && yt<0)
			{
				if((Math.abs(yt)%2==0 && (xt<=Math.abs(yt)+1)) || (xt%2==1 && (yt<=0 && yt>=-xt+1)) )
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
			
			
	}
}
