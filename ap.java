import java.util.*;
public class ap
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int d;
		for(int i = 0; i<t; i++)
		{
			int[] arr = new int[t];
			arr[i] = sc.nextInt();
		}
		int d1 = arr[1]-arr[0];
		int d2 = arr[2]-arr[1];
		int d3 = arr[3]-arr[2];
		if(d1==d2)
		{
			d = d1;
		}
		else
		{
			if(d3==d2)
			{
				d = d2;
			}
			else 
			{
				d = d1;
			}
		}
		for(int j=0;j<t-1;j++)
		{
			if (arr[j+1]!= arr[j])
			{
				System.out.println(arr[j]+d);
				break;
			}
		}

	}
}