import java.math.BigInteger;
import java.util.*;


class ChefAndRainbowArray 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long x;
		ChefAndRainbowArray rb = new ChefAndRainbowArray();
		if(n<13)
		{
			System.out.println("0");
		}
		else
		{
			if(n%2==0)
			{
				n = n-1;
			}
			
			x=(rb.binomialCoeff((n-1)/2,6));
			x = ((x%1000000007)+1000000007)%1000000007;
			System.out.println(x);
		}
	}
	
	long binomialCoeff(int n, int k)
	{
		int C[] = new int[k+1];
	    int i, j;
	    long res;
	    C[0] = 1;
	    for(i = 1; i <= n; i++)
	    {
	        for(j = Math.min(i, k); j > 0; j--)
	            C[j] = C[j] + C[j-1];
	    }
	    res = C[k];  // Store the result before freeing memory
	    return res;
	}
}
