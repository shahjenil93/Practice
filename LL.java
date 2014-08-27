class LL
{
	private Node first, pos;

	public LL()
	{
		first = null;
	}

	public boolean isnull()
	{
		
		return first==null;
	}

	public void insert(int d1)
	{
			if (first == null)
			{
				first = new Node(d1);
				pos  = first;
			}

		else 
		{
			Node two = new Node(d1);
			first.next = two; 
			first = two;
		}
	}

	 public void printlist()
	 {
	 	Node current  = pos;
	 	System.out.println("List elements are");
	 	while(current!=null)
	 	{
	 		current.printListElements();
	 		current = current.next;
	 	}
	 }

	 Node deleteNode(Node head, int d)
	 {
	 	Node n = head;
	 	if(n.data==d)
	 	{
	 		return head.next;  //moved head
	 	}
	 	while(n.next!=null)
	 	{
		if(n.next.data == d)
			{
				n.next = n.next.next;
				return head;
			}
			n = n.next;
	 	}
	 	return head;
	 }

	 public static void main(String[] args)
	 {
	 	LL ll = new LL();
	 	System.out.println(ll.isnull());
	 	ll.insert(1);
	 	ll.insert(5);
	 	ll.insert(2);
	 	ll.insert(3);
	 	ll.insert(6);
	 	ll.deleteNode(1,1);
	 	ll.printlist();
	 }
}