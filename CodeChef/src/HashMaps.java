import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HashMaps 
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,3,2,1};
		int count=0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], ++count);
		//	count  = map.get(arr[i]);

		}
		String[] keys = map.keySet().toArray(new String[map.size()]);
		
		for(int j=0;j<keys.length;j++)
		{
			if(map.get(keys[j])%2==1)
			{
				System.out.println(map.get(keys[j]));
			}
		}
	//	String keys[] = map.keySet().toArray(new String[map.size()]);
		System.out.println(map);
	//	System.out.println(keys[0]);
		
//		Enumeration<String> names = map.keySet();
		
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("I am", "awesum!");
		//String names = map.keySet();
	}
}
