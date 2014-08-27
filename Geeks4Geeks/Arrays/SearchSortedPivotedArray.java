import java.util.*;

class SearchSortedPivotedArray
{
	public static void main(String[] args)
	{
		//int arr[] = new int[6];
		int arr[] = {4,5,6,7,8,2,3};
		//System.out.println(arr[0]);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SearchSortedPivotedArray sspa = new SearchSortedPivotedArray();
		int index=sspa.pivotedBinarySearch(arr,0,arr.length-1,n);
		System.out.println(index);
	}


	public int findPivot(int arr[],int left, int right)
	{
		if(right < left) return -1;
		if(right == left) return left;

		int mid = (left + right)/2;
		if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
		{
			return mid;
		}
		else if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1])
		
		{
			return mid-1;
		}

		if(arr[mid]>arr[left])
		{
			return findPivot(arr,mid+1, right);
		}
		else 
		{
			return findPivot(arr,left, mid-1);
		}
		
	}	

	public int binarySearch(int arr[], int left, int right, int n)
	{
		if(right<left) return -1;
		int mid = (left + right)/2;
		if(n == arr[mid])
			return mid;
		if( n < arr[mid])
		return	binarySearch(arr,left,mid-1,n);
		else
		return	binarySearch(arr,mid+1,right,n);
		}
	

	public int pivotedBinarySearch(int arr[], int left, int right, int n)
	{
		int pivot = findPivot(arr,0,arr.length-1);
		if(pivot == -1)
    		 return binarySearch(arr, 0, arr.length-1, n);
    	if(arr[pivot]==n)
    		return pivot;
		if(n>arr[0])
		{
			binarySearch(arr,pivot+1,arr.length-1,n);
		}
		else
		{
			binarySearch(arr,0, pivot-1,n);
		}
	return n;
	}
}