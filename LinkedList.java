public class LinkedList
{
	private Link first;

	public LinkedList()
	{
		first = null;
	}

	public Boolean isempty()
	{
		return first==null;
	}

	public void insert(String s1, String s2, double d1)
	{
		Link linklist = new Link(s1,s2,d1);
		linklist.next = first;
		first = linklist;
	}

	public Object delete()
	{
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void printlist()
	{
		Link current  = first;
		System.out.println("List Elements are: ");
		while(current!=null)
		{
			current.printListElements();
			current = current.next;
		}
	}


	public static void main(String[] args)
	{
		LinkedList linkedlist1 = new LinkedList();
		linkedlist1.insert("150/14","John",1500.00);
		linkedlist1.insert("982/41","Sufiyan",2000.00000);
		linkedlist1.insert("9/11","Raj",10000);

		linkedlist1.printlist();
		linkedlist1.delete();
		linkedlist1.printlist();

	}
}
