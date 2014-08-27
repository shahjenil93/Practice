class LinkedList1
{
	private static Node1 first;

	public LinkedList1()
	{
		first = null;
	}

	static public boolean isEmplty()
	{
		return first==null;
	}

	static public int size(Node1 first)
	{
		int count=0;
		Node1 counter = first;
		while(counter.next!=null) 
		{
			count++;
		}
		return count;
	}

	static Node1 insertnode(Node1 first, Node1 toInsert, int n)
	{
		int length = size(first);
		
		if(first==null)
		{	
			length=0;
		}

		

		if(first==null)
		{
			return toInsert;
		}
		
		if(n==1)
		{
			toInsert.next=first;
			return toInsert;
		}

		else 
		{
			Node1 traverse = first;
			int addcounter = 1;
			while(addcounter<n-1)
			{
				traverse = traverse.next;
				addcounter++;
			}
			Node1 currentnode = traverse;
			currentnode.next = traverse.next;
			traverse.next = currentnode;
			return first;
		}

	}



	public static void main(String[] args)
	{
		LinkedList1 ll1 = new LinkedList1();
		ll1.insertnode(first, first,1);
	}
}