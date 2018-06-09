import java.util.ArrayList;


public class ACSLQuine {
	public String[]table = {"0000","0001","0010","0011",
			"0100","0101","0110","0111",
			"1000", "1001", "1010","1011",
			"1100","1101","1110","1111"};
	
	public String letters(String a)
	{
		String letterstring = "";
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
		//System.out.println("I1: " + index1 + "  I2: " + index2);

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
			return "NONE";
		else 
			return combined;
		
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
		//System.out.println("I1: " + index1 + "  I2: " + index2);
		if((index1-index2 > 1)||(index1-index2 < -1)||(index1-index2==0))
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
			return "NONE";
		else 
			return combined;

	}
	public void execute(String input)
	{
		System.out.println("Intermediate");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int start = 0;
		for(int i = 0; i < input.length(); i++)
		{
			start = i;
			while((i < input.length())&&(input.charAt(i)!=' '))
				i++;
			
			nums.add(Integer.valueOf(input.substring(start,i)));
		}//System.out.println(nums);
		
		
		String output = "";
		if(nums.size()==2)
		{
			if((table[nums.get(0)] != "")&&(table[nums.get(1)]!= ""))
				output = combine(nums.get(0),nums.get(1));
			else
				output = "NONE";
		}else if(nums.size()==4)
		{
			if((table[nums.get(0)] != "")&&(table[nums.get(1)]!= "")&&(table[nums.get(2)] != "")&&(table[nums.get(3)]!= ""))
				output = combine(combine(nums.get(0),nums.get(1)),combine(nums.get(2),nums.get(3)));
			else
				output = "NONE";
		}
		if(output != "NONE")
			output += ", " + letters(output);
		
		System.out.println(output);
	}
	public ACSLQuine(String a, String b, String c, String d, String e, String f)
	{
		int[] function = new int[16];
		for(int i = 0; i < 16; i++)
			function[i]=0;
		
		int start = 0;
		for(int i = 0; i < a.length(); i++)
		{
			start = i;
			while((i < a.length())&&(a.charAt(i)!=' '))
				i++;
			
			if(Integer.valueOf(a.substring(start,i)) != -1)
				function[Integer.valueOf(a.substring(start,i))] = 1;
		}
		
		for(int i = 0; i < 16; i++)
			if(function[i]==0)
				table[i]= "";
		
		execute(b);
		execute(c);
		execute(d);
		execute(e);
		execute(f);
	}
}
