import java.util.Arrays;
import java.util.Scanner;


class CleaningTables 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int q=0;q<t;q++)
		{
			int n = sc.nextInt();
			int cust = sc.nextInt();
			int order[] = new int[cust];
			//int order_sort[] = new int[cust];
			for(int i=0;i<cust;i++)
			{
				order[i]=sc.nextInt();
			}
			int tables[] = new int[n];
			int ahead[] = new int[tables.length];
			int count=0;
			for(int i=0;i<cust;i++)
			{
				boolean pres =false;
				for(int j=0;j<n;j++)
				{
					if(order[i]==tables[j])
					{
						pres = true;
					}
				}
				
				if(pres == true)
				{
					continue;
				}
				else
				{
					for( int j=0;j<n;j++)
					{
						if(tables[j]==0)
						{
							tables[j]=order[i];
							pres=true;
							count++;
							break;
						}
					}
					if(pres == true)
					{
						continue;
					}
					else
					{
						for(int j=0;j<n;j++)
						{
							ahead[j]=0;
						}
						int present = 0;
						int min=0;
						boolean available = false;
						boolean farthest[] = new boolean[n];
						//System.out.println(farthest[0]);
						
						
						for(int k=i;k<cust;k++)
						{
							for(int j=0;j<n;j++)
							{
								if(order[k]==tables[j] && farthest[j]==true)
								{
				//					System.out.println("k"+k);
			//						System.out.println("farthest"+j+" "+farthest[j]);
								}
								if(order[k]==tables[j] && farthest[j]==false)
								{
				//					System.out.println("k"+k);
				//					System.out.println("farthest"+j+" "+farthest[j]);
									ahead[j]++;
									farthest[j] = true;
									min = j;
								}
								
							}
						}
			//			System.out.println("min"+min);
						
						for(int j=0;j<ahead.length;j++)
						{
							if(ahead[j]==0)
							{
								present = j;
								available = true;
							}
						}
				//		System.out.println("present"+present);
						
						
						if(available==true)
						{
						//	System.out.println(tables[present]);
							tables[present] = order[i];
							count++;
						}
						else
						{
					//		System.out.println(tables[min]);
							tables[min] = order[i];
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}
}
