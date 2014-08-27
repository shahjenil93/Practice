public class Link
{
	String data1, data2;
	double income;
	public Link next;

	public Link(String d1, String d2, double cash)
	{
		data1 = d1;
		data2 = d2;
		income = cash;
	}

	public void printListElements()
	{
		System.out.println("Elements are:" +data1+data2+income);
	}
}