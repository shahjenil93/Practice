import java.util.Scanner;


public class DashBoard 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int q=0;q<t;q++)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
			int min;
			int max;
			int maxpos, minpos;
			DashBoard db = new DashBoard();
			for(int j=0;j<arr.length-1;j++)
			{
				if((arr[j])%2==0)
				{
					maxpos = j;
					max = arr[j];
					for(int k=j+1;k<arr.length;k++)
					{
						
						if(arr[k]%2==0)
						{
							if(arr[k]>max)
							{
								max = arr[k];
								maxpos = k;
							}
						}
						else
						{
							continue;
						}
					}
			//		System.out.println("before swapping"+arr[j]);
					int temp;
					temp = arr[j];
					arr[j] = arr[maxpos];
					arr[maxpos] = temp;
					//db.swap(arr[j], arr[maxpos]);
			//		System.out.println("after swapping"+arr[j]);
				}
				
				else
				{
					minpos = j;
					min = arr[j];
					for(int k=j+1;k<arr.length;k++)
					{
						if(arr[k]%2==1)
						{
							if(arr[k]<min)
							{
								min = arr[k];
								minpos = k;
							}
						}
						else
						{
							continue;
						}
					}
				//	System.out.println("before swapping"+arr[j]);
					int temp;
					temp = arr[j];
					arr[j] = arr[minpos];
					arr[minpos] = temp;
					//db.swap(arr[j], arr[maxpos]);
					//System.out.println("after swapping"+arr[j]);
				}
				
			}
			
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i] +" ");
			}
				
		}
	}
	
public void swap(int a, int b)
	{
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a+"should swap with"+b);
	}
}
