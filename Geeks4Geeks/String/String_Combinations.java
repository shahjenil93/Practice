class String_Combinations
{
	public static void main(String[] args)
	{
		String_Combinations sc = new String_Combinations();
		String str = "abc";
		StringBuffer sb = new StringBuffer();
		sc.Combination(str, sb, 0);
	}

	void Combination(String instr, StringBuffer outstr, int index)
	{
		for (int i = index; i < instr.length(); i++)
		{
		outstr.append(instr.charAt(i));
		System.out.println(outstr);
		Combination(instr,outstr,i+1);
		outstr.deleteCharAt(outstr.length()-1);
	}}
}