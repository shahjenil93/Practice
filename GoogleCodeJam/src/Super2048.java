import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Super2048 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File text = new File("/Users/jenil/Documents/Programming/Practice/GoogleCodeJam/B-large-practice.in.txt");
		File outFile = new File ("submitlarge.txt");
	   
	    PrintWriter pWriter = new PrintWriter (outFile);
		//Scanner sc = new Scanner(text);
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		for(int q=0;q<t;q++)
		{
			int n = sc.nextInt();
			String dir = sc.next();
			int matrix[][] = new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					matrix[i][j] = sc.nextInt();
				}
			}
			
			//if shift is right
			
			//shift Zeros
			if(dir.equalsIgnoreCase("right"))
			{
				int k=0;
				while(k<n)
				{
				for(int i=0;i<n;i++)
				{
					for(int j=n-1;j>0;j--)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i][j-1];
							matrix[i][j-1] = temp;
								
						}
					}
				}
				k++;
				}
				
//				System.out.println("Before Shifting");
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<n;j++)
//					{
//						System.out.print(matrix[i][j]+" "); 
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				
				for(int i=0;i<n;i++)
				{
					boolean match = false;
					int pos=0;
					for (int j=n-1;j>0;j--)
					{
						if(matrix[i][j]==matrix[i][j-1])
						{
							match = true;
							if(pos<j-1)
								pos = j-1;
							matrix[i][j] = 2*matrix[i][j-1];
							matrix[i][j-1] = 0;
							int temp = 0;
							j--;
							//System.out.println(pos);
						}
					}
				
					if(match)
					{
						for(int j=pos;j>0;j--)
						{
							matrix[i][j] = matrix[i][j-1];
						}
						matrix[i][0]=0;
					}
				}
				
				
				k=0;
				while(k>n)
				{
				for(int i=0;i<n;i++)
				{
					for(int j=n-1;j>0;j--)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i][j-1];
							matrix[i][j-1] = temp;
								
						}
					}
				}
				}
			}
			
			if(dir.equalsIgnoreCase("left"))
			{
				int k=0;
				while(k<n)
				{
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<n-1;j++)
						{
							if(matrix[i][j]==0)
							{
								int temp = 0;
								temp = matrix[i][j];
								matrix[i][j] = matrix[i][j+1];
								matrix[i][j+1] = temp;
								
							}
						}
					}
					k++;
				}
				
				
				
				
//				System.out.println("Before Shifting");
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<n;j++)
//					{
//						System.out.print(matrix[i][j]+" "); 
//					}
//					System.out.println();
//				}
//				System.out.println();

				
				
				for(int i=0;i<n;i++)
				{
					boolean match = false;
					int pos=0;
					for (int j=0;j<n-1;j++)
					{
						if(matrix[i][j]==matrix[i][j+1])
						{
							match = true;
							if(pos<j+1)
								pos = j+1;
							matrix[i][j] = 2*matrix[i][j+1];
							matrix[i][j+1] = 0;
							int temp = 0;
							j++;
						}
					}
				
					if(match)
					{
						for(int j=pos;j<n-1;j++)
						{
							matrix[i][j] = matrix[i][j+1];
						}
						matrix[i][n-1]=0;
					}
				}
				
				
				k=0;
				while(k<n)
				{
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<n-1;j++)
						{
							if(matrix[i][j]==0)
							{
								int temp = 0;
								temp = matrix[i][j];
								matrix[i][j] = matrix[i][j+1];
								matrix[i][j+1] = temp;
								
							}
						}
					}
					k++;
				}
				
				
			}
			
			// if the matirx is to be shifted up
			if(dir.equalsIgnoreCase("up"))
			{
				int k=0;
				while(k<n)
				{
				for(int j=0;j<n-1;j++)
				{
					for(int i=0;i<n-1;i++)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i+1][j];
							matrix[i+1][j] = temp;
								
						}
					}
				}
				k++;
				}
				
//				System.out.println("Before Shifting up");
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<n;j++)
//					{
//						System.out.print(matrix[i][j]+" "); 
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				for(int j=0;j<n;j++)
				{
					boolean match = false;
					int pos=0;
					for (int i=0;i<n-1;i++)
					{
						if(matrix[i][j]==matrix[i+1][j])
						{
							match = true;
							if(pos<i+1)
								pos = i+1;
							matrix[i][j] = 2*matrix[i+1][j];
							matrix[i+1][j] = 0;
							int temp = 0;
							i++;
						}
					}
				
					if(match)
					{
						for(int i=pos;i<n-1;i++)
						{
							matrix[i][j] = matrix[i+1][j];
						}
						matrix[n-1][j]=0;
					}
				}
				

				
				
				
				k=0;
				while(k<n)
				{
				for(int j=0;j<n;j++)
				{
					for(int i=0;i<n-1;i++)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i+1][j];
							matrix[i+1][j] = temp;
								
						}
					}
				}
				k++;
				}
				
			}
			
			
			//if the direction is down
			if(dir.equalsIgnoreCase("down"))
			{
				int k=0;
				while(k<n)
				{
				for(int j=0;j<n-1;j++)
				{
					for(int i=n-1;i>0;i--)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i-1][j];
							matrix[i-1][j] = temp;
								
						}
					}
				}
				k++;
				}
				
//				System.out.println("Before Shifting down");
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<n;j++)
//					{
//						System.out.print(matrix[i][j]+" "); 
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				
				//code to add elements in the matrix
				for(int j=0;j<n;j++)
				{
					boolean match = false;
					int pos=0;
					for (int i=n-1;i>0;i--)
					{
						if(matrix[i][j]==matrix[i-1][j])
						{
							match = true;
							if(pos<i-1)
								pos = i-1;
							matrix[i][j] = 2*matrix[i-1][j];
							matrix[i-1][j] = 0;
							int temp = 0;
							i--;
						}
						
					}
					//System.out.println(pos);
				
					if(match)
					{
						for(int i=pos;i>0;i--)
						{
							matrix[i][j] = matrix[i-1][j];
						}
						matrix[0][j]=0;
					}
				}
				
				k=0;
				while(k<n)
				{
				for(int j=0;j<n;j++)
				{
					for(int i=n-1;i>0;i--)
					{
						if(matrix[i][j]==0)
						{
							int temp = 0;
							temp = matrix[i][j];
							matrix[i][j] = matrix[i-1][j];
							matrix[i-1][j] = temp;
								
						}
					}
				}
				k++;
				}
				
			}			
			
			
			
			//print the matrix
			System.out.println("Case #"+(q+1)+": ");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					
					System.out.print(matrix[i][j]+" "); 
					pWriter.flush();
				}
				System.out.println();
				pWriter.flush();
				pWriter.close();
			}
		}
	}
}
