class knapsack
{
	public static void main(String[] args)
	{
		int sack[][] = {(1,1),(6,2),(18,5),(22,6),(28,7)};
		int i, w;
		int bag[][] = new int[5][11];
		
		for(w=0;w<11;w++)
		{		
			bag[0][w]=0;
		}
		for(i=0;i<5;i++)
		{
			bag[i][0]=0;
		}

		for(i=1;i<5;i++)
		{
			for(w=1;w<11;w++)
			{
				if(sack[i][1]>w)
				{
					bag[i][w] = bag[i-1][w];
				}
				else
				{
					bag[i][w] = Math.max(bag[i-1][w], sack[i][0]+bag[i-1][11-sack[i][1]]);
				}
			}
		}
		System.out.println(bag[4][10]);
	}

}