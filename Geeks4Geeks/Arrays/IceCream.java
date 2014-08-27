import java.util.*;
import java.lang.*;

class IceCream
{
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        for(int f=0;f<t;f++)
        {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                    if(arr[i]+arr[j]==m)
                    {
                        System.out.println(String.valueOf(i+1)+" "+String.valueOf(j+1));    
                    }
            }
        }
        }
    }
}