import java.util.ArrayList;


public class ACSLQuine {
	public String[]table = {"0000","0001","0010","0011",
			"0100","0101","0110","0111",
			"1000", "1001", "1010","1011",
			"1100","1101","1110","1111"};
	public ArrayList<String> combine1 = new ArrayList<String>();
	public ArrayList<String> combine2 = new ArrayList<String>();
	
	public String letters(String a)
	{
		String letterstring = "";
		if(a.charAt(0)=='0')
		{
			if(a.charAt(1)=='1')
				letterstring += "A";
			else if(a.charAt(1)=='0')
				letterstring += "a";
			if(a.charAt(2)=='1')
				letterstring += "B";
			else if(a.charAt(2)=='0')
				letterstring += "b";
			if(a.charAt(3)=='1')
				letterstring += "C";
			else if(a.charAt(3)=='0')
				letterstring += "c";
		}else
		{
			if(a.charAt(0)=='1')
				letterstring += "A";
			else if(a.charAt(0)=='0')
				letterstring += "a";
			if(a.charAt(1)=='1')
				letterstring += "B";
			else if(a.charAt(1)=='0')
				letterstring += "b";
			if(a.charAt(2)=='1')
				letterstring += "C";
			else if(a.charAt(2)=='0')
				letterstring += "c";
			if(a.charAt(3)=='1')
				letterstring += "D";
			else if(a.charAt(3)=='0')
				letterstring += "d";
		}
				
		return letterstring;
	}
	
	public String combine(int x, int y)
	{
		String combined = "";
		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i < 4; i++)
		{
			if(table[x].charAt(i) == '1')
				index1++;
			
			if(table[y].charAt(i) == '1')
				index2++;
			
		}
		//System.out.println("("+x+","+y+")" + "  I1: " + index1 + "  I2: " + index2);

		if((index1-index2 > 1)||(index1-index2 < -1)||(index1-index2==0))
		{
			return "NONE";
		}

		for(int i = 0; i < 4; i++)
		{
			if(table[x].charAt(i) ==table[y].charAt(i))
				combined += table[x].charAt(i) ;
			else
				combined += "x";
		}
		
		
		int numXs = 0;
		for(int i = 0; i < combined.length(); i++)
			if(combined.charAt(i)=='x')
				numXs++;
		if(numXs > 2)
		{
			return "NONE";
		}else 
		{
			//System.out.println("-------------They combined!: " + x + "  " + y);
			combine1.add(combined);
			return combined;
		}
		
	}
	
	public String combine(String x, String y)
	{
		String combined = "";
		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i < 4; i++)
		{
			if(x.charAt(i) == '1')
				index1++;
			
			if(y.charAt(i) == '1')
				index2++;
		}
		//System.out.println("("+x+","+y+")" + "  I1: " + index1 + "  I2: " + index2);
		
		if((index1-index2 > 1)||(index1-index2 < -1)||(index1-index2==0))
		{
			return "NONE";
		}
		if(x.indexOf('x') != y.indexOf('x'))
		{
			return "NONE";
		}
		for(int i = 0; i < 4; i++)
		{
			if(x.charAt(i)==y.charAt(i))
				combined += x.charAt(i);
			else
				combined += "x";
		}
		
		
		int numXs = 0;
		for(int i = 0; i < combined.length(); i++)
			if(combined.charAt(i)=='x')
				numXs++;
		
		if(numXs > 2)
		{
			return "NONE";
		}
		else 
		{
			//System.out.println("-------------They combined!: " + x + "  " + y);
			combine2.add(combined);
			return combined;
		}

	}
	public void execute(String input)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int start = 0;
		for(int i = 0; i < input.length(); i++)
		{
			start = i;
			while((i < input.length())&&(input.charAt(i)!=' '))
				i++;
			
			if(Integer.valueOf(input.substring(start,i)) != -1)
				nums.add(Integer.valueOf(input.substring(start,i)));
		}//System.out.println(nums);
		
		
		for(int i = 0; i < nums.size(); i++)
		{
			for(int j = i; j < nums.size(); j++)
			{
				combine(nums.get(i),nums.get(j));
			}//System.out.println("I: " + i + "   " + combine1);
		}
		//System.out.println(combine1);
		//System.out.println("-------------------------Extended Time");
		
		
		for(int i = 0; i < combine1.size(); i++)
		{
			for(int j = i; j < combine1.size(); j++)
			{
				combine(combine1.get(i),combine1.get(j));
			}//System.out.println("I: " + i + "   " + combine2);
		}
		//BUBBLE SORT
		
		for(int j = 0; j < combine2.size(); j++)
		{
			for(int i = 0; i < combine2.size()-1; i++)
			{
				if((combine2.get(i)).compareToIgnoreCase(combine2.get(j)) < 0)
				{
					String t1 = combine2.get(j);
					combine2.set(j,combine2.get(i));
					combine2.set(i, t1);
				}
			}
		}
		//DELETE DUPLICATES
		if(combine2.size()> 0)
		{
			for(int i = 0; i < combine2.size()-1; i++)
			{
				if(combine2.get(i).equals(combine2.get(i+1)))
				{
					combine2.remove(i);
				}
			}
		}//System.out.println("FINAL:     " + combine2);
		
		
		if(combine2.size() > 0)
		{
			for(int i = 0; i < combine2.size(); i++)
			{
				if(i != 0)
				{
					System.out.print(" + ");
				}
				System.out.print(letters(combine2.get(i)));
			}
		}else
		{
			for(int i = 0; i < combine1.size(); i++)
			{
				if(i!=0)
				{
					System.out.print(" + ");
				}
				System.out.print(letters(combine1.get(i)));
			}
		}
		
		System.out.println();
		
	}
	public ACSLQuine(String a, String b, String c, String d, String e)
	{
		System.out.println("Senior");
		execute(a);
		combine1.clear();
		combine2.clear();
		execute(b);
		combine1.clear();
		combine2.clear();
		execute(c);
		combine1.clear();
		combine2.clear();
		execute(d);
		combine1.clear();
		combine2.clear();
		execute(e);
	}
}
