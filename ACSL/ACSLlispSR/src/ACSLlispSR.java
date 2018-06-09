import java.util.ArrayList;
import java.util.Collections;


public class ACSLlispSR {
    public ArrayList<String> operators = new ArrayList<String>();
	public ArrayList<String> values = new ArrayList<String>();
	
	
	public void mySort(int x, int y)
	{
		ArrayList<String> operators2 = new ArrayList<String>();
		ArrayList<String> values2 = new ArrayList<String>();
		for(int i = 0; i < operators.size(); i++)
		{
			operators2.add(operators.get(i));
			values2.add(values.get(i));
		}
        for(int j=x;j<y+1;j++)
        {
            for(int i=j+1;i<y+1;i++)
            {
                if((operators2.get(i)).compareToIgnoreCase(operators2.get(j))<0)
                {
                	//System.out.println("SWAP");
                    String t1 = operators2.get(j);
                    String t2 = values2.get(j);
                    operators2.set(j,operators2.get(i));
                    values2.set(j,values2.get(i));
                    operators2.set(i,t1);
                    values2.set(i,t2);
                }
            }
        }
		String output = "";
		for(int i = 0; i < operators2.size(); i++)
		{
			output+=operators2.get(i) + " ";
			if(i!=0)
			{
				output+=values2.get(i) + ") ";
			}
		}
		System.out.println(output.substring(0,output.length()-1) + ")");
	}
	public void count()
	{
		System.out.println(operators.size()-1);
	}
	public String max()
	{
		int theSublist = 0;
		int maxNum = 0;
		int count = 0;
		String output= "";
		for(int i = 0; i < values.size(); i++)
		{
			count = 0;
			for(int j = 0; j < values.get(i).length(); j++)
			{
				if(values.get(i).charAt(j) == ' ')
				{
					count++;
				}
			}
			if(count > maxNum)
			{
				theSublist = i;
				maxNum = count;
				count = 0;
			}
		}
		output += operators.get(theSublist) + " " + values.get(theSublist);
		System.out.println( output + ")");
		return output;
	}
	public void myReverse(int x, int y)
	{
		String reversed = "";
		ArrayList<String> operators2 = new ArrayList<String>();
		ArrayList<String> values2 = new ArrayList<String>();
		for(int i = 0; i < operators.size(); i++)
		{
			operators2.add(operators.get(i));
			values2.add(values.get(i));
		}
		for(int i = 0; i <= (y-x)/2; i++)
		{
			
			//System.out.println("SWAP: i: " + i + operators2.get(i+x) + " " + operators2.get(y-i));
			Collections.swap(operators2, i+x, y-i);
			Collections.swap(values2, i+x, y-i);
		}
		//System.out.println("SWAPPED");
		reversed += operators2.get(0) +" ";
		for(int i = 1; i < x; i++)
		{
			reversed+= operators2.get(i) + values2.get(i) + ") ";
		}
		//System.out.println("Before: " + reversed);
		String inside = "";
		//String num = "";
		int start = 0;
		for(int i = x; i < y+1; i++)
		{				
			reversed+=operators2.get(i);
			values2.set(i,values2.get(i)+" ");
			//System.out.println("WE INi");
			inside = "";
			start = 0;
			for(int j = 0; j < values2.get(i).length();j++)
			{
				//System.out.println("WE INj: " + values2.get(i) + "Size: " + values2.get(i).length());
				while((j < values2.get(i).length())&&(values2.get(i).charAt(j)!= ' '))
				{
					j++;
				}
				//System.out.println("outwhile: " + j);
				//System.out.println("NUM: " + values2.get(i).substring(start, j));
				if(inside =="")
					inside+= " " + values2.get(i).substring(start, j);
				else
					inside = values2.get(i).substring(start, j) + inside;
			//	System.out.println("Inside: " + inside);
				start = j;
			}
			reversed+=inside + ") ";
		}
		for(int i = y+1; i < operators2.size(); i++)
		{
			reversed += operators2.get(i) +" " + values2.get(i) + ") ";
		}
		//System.out.println("REVERSE: ");
		System.out.println(reversed.substring(0,reversed.length()-1) + ")");
		
	}
	public void myRemove(int x, int y)
	{
		String removed = "";
		removed += operators.get(0) +" ";
		for(int i = 1; i < x; i++)
		{
			removed += operators.get(i) +" " + values.get(i) + ") ";
		}
		for(int i = y+1; i < operators.size(); i++)
		{
			removed += operators.get(i) +" " + values.get(i) + ") ";
		}
		//System.out.println("REMOVE: ");
		System.out.println(removed.substring(0,removed.length()-1) + ")");
	}

	public ACSLlispSR(String a, String b, String c, String d, String e, String f)
	{
		int start = 0;
		for(int i = 1; i < a.length(); i++)
		{
			if(i == 1)
			{
				while(a.charAt(i)!= '(')
				{
					i++;
				}
				operators.add(a.substring(0,i-1));	
				values.add("");
				//System.out.println(a.substring(0, i-1));
			}
			if(a.charAt(i)== '(')
			{
				start = i;
				while(a.charAt(i)!= ' ')
				{
					i++;
				}
				operators.add(a.substring(start,i));
				//System.out.println(a.substring(start,i));
				start = i;
				while(a.charAt(i)!= ')')
				{
					i++;
				}
				values.add(a.substring(start+1,i));
			}
		}
		//System.out.println("Start");
		//myReverse(1,4);
		
		
		String[] input = new String[]{b,c,d,e,f};
		for(int z = 0; z < 5; z++)
		{
			System.out.print((z+1) +". ");
			if(input[z].charAt(0) == 'C')
			{
				count();
			}else if(input[z].charAt(0)=='R')
			{
				if(input[z].charAt(2)=='M')
				{
					myRemove(input[z].charAt(7)-'0',input[z].charAt(9)-'0');
				}
				if(input[z].charAt(2)=='V')
				{
					myReverse(input[z].charAt(8)-'0',input[z].charAt(10)-'0');
				}
			}else if(input[z].charAt(0)=='S')
			{
				mySort(input[z].charAt(5)-'0',input[z].charAt(7)-'0');
			}else if(input[z].charAt(0)=='M')
			{
				max();
			}
			System.out.println();
		}
	}
}
