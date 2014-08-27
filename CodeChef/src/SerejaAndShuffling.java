import java.util.Scanner;


class SerejaAndShuffling 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		SerejaAndShuffling sas = new SerejaAndShuffling();
		int arr[] = new int[t];
		int n = arr.length;
		int l=0,r=3*n;
		int count=0;
		int total=0;
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i=0;i<t;i++)
		{
			arr[i] = sc.nextInt();
		}

		
		while(count<=2*n)
		{
			if(n==2)
			{
				break;
			}
			
			int score=sas.f(arr);
			int temp_score = score;
			if(score==0)
			{
				break;
			}
			else
			{
				if(score>0)
				{
					 l=sas.findMax(arr, 0 , n/2);
					 r=sas.findMin(arr, n/2, arr.length);
					//sas.swap(arr, l, r);
				}
				if(score<0)
				{
					 l = sas.findMin(arr, 0, n/2);
					 r = sas.findMax(arr, n/2, arr.length);
				}
				count+=r-l+1;
				if(count>2*n)
				{
					break;
				}
				sas.swap(arr, l, r);
				score = temp_score;
				int final_score= sas.f(arr);
				if(Math.abs(final_score)<=Math.abs(score))
				{
					x[total] = l;
					y[total] = r;
					total++;
				}
			}
			
		}
		System.out.println(total);
		for(int i=0;i<total;i++)
		{
			System.out.println(x[i]+1+" "+(y[i]+1));
		}
	}
	
	public int f(int arr[])
	{
		int n = arr.length;
		int sum=0;
		for(int i=0;i<n/2;i++)
		{
			sum+=arr[i];
		}
		for(int i=n/2;i<arr.length;i++)
		{
			sum-=arr[i];
		}
		return sum;
	}
	
	public void swap(int arr[], int l, int r)
	{
		int temp=arr[l];
		for(int i=l+1;i<=r;i++)
		{
			arr[i-1]=arr[i];
		}
		arr[r] = temp;
		
	}
	
	public int findMax(int arr[], int left, int right)
	{
		int n = arr.length;
		int temp = 0;
		int i;
		for(i=left;i<right;i++)
		{
			if(arr[i]>temp)
			{
				temp = i;
			}
		}
		return temp;
	}
	
	public int findMin(int arr[], int left, int right)
	{
		int n = arr.length;
		int temp = left;
		int i=left;
		for(i=left;i<right;i++)
		{
			if(arr[i]<temp)
			{
				temp = i;
			}
		}
		return temp;
	}
}
