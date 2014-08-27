import java.util.*;

class FindPattern_2DArray
{
	public static void main(String[] args)
	{

		String[][] matrix = new String[5][5];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				String[i][j] = sc.next();
			}
		}

		int count[][] = new int[5][5];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				count[i][j] = 0;
			}
		}

		String pattern = "microsoft";
		int k=0;

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(matrix[i][j].equals(pattern.charAt(k)) && count[i][j]==0)
				{
					count[i][j] = 1;
					while(k!=pattern.lengeth()-1)
					{
						
					}
				}
			}
		}	}
}