import java.util.PriorityQueue;
import java.util.Stack;


public class PQ 
{
	public static void main(String[] args)
	{
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
		pqueue.add(70);
		pqueue.add(40);
		pqueue.add(60);
		pqueue.add(90);
		pqueue.add(30);
		pqueue.add(80);
		pqueue.add(20);
		pqueue.add(70);
		pqueue.add(80);
		int x = pqueue.peek();
		System.out.println(x);
		int n = pqueue.size();
		Integer[] arr1 = new Integer[5];
		Integer[] arr2 = pqueue.toArray(arr1);
		
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(5);
		st.push(3);
		st.pop();
		st.peek();
		
	}
}
