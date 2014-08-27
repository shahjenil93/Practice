import java.util.*;

class Palindrome_StringReduce
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String st = sc.next();    
            int count=0;
            int left=0;
            
            int right = st.length()-1;
            while(left<right)
            {
                
                    count += Math.abs(st.charAt(left)-st.charAt(right));
                    left++;
                    right--;
            }
            System.out.println(count);
        }
    }
}