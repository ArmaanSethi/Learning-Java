import java.util.ArrayList;


public class ACSLlispINT {

	public ACSLlispINT(String a, String b, String c, String d, String e)
	{
		/*Scanner scan = new Scanner(System.in);
		String inputa = scan.nextLine();
		String inputb = scan.nextLine();
		String inputc = scan.nextLine();
		String inputd = scan.nextLine();
		String inpute = scan.nextLine();*/
		System.out.println("1: " + a);	
		System.out.println("2: " + b);	
		System.out.println("3: " + c);	
		System.out.println("4: " + d);	
		System.out.println("5: " + e);	
		System.out.println();	
		System.out.println();	
		//1
		String aOut = "";
		for(int i = 1; i < a.length()-2; i++)
			aOut += a.charAt(a.length()-i-1);

		System.out.println("1: " + "'(" + aOut + ")");
		//2
		String bOut = "";
		for(int i = 1; i < b.length(); i++)
			if(!((b.charAt(i)== ' ')||(b.charAt(i)== '(')||(b.charAt(i)== ')')))
				bOut+=b.charAt(i);
		//System.out.println(bOut);
		ArrayList<String> bList = new ArrayList<String>();
		int count = 1;
		for(int i = 0; i < bOut.length()-1; i++)
		{
			while((i<(bOut.length()-1))&&(bOut.charAt(i)==bOut.charAt(i+1)))
			{
				count++;
				i++;
			}
			bList.add("("+count+" "+bOut.charAt(i)+")");
			count = 1;
			//System.out.println("ADD" + bList.get(bList.size()-1));
		}
		System.out.print("2: ");	
		bOut = "";
		for(int i = 0; i < bList.size(); i++)
			bOut += bList.get(i)+" ";	

		System.out.println("'(" + bOut.substring(0, bOut.length()-1)+")");
		//3
		String cOut = "";
		for(int i = 1; i < c.length(); i++)
			if(!((c.charAt(i)== ' ')||(c.charAt(i)== '(')||(c.charAt(i)== ')')))
				cOut+=c.charAt(i);
		
		ArrayList<String> cList = new ArrayList<String>();
		count = 1;
		for(int i = 0; i < cOut.length()-1; i++)
		{
			while((i<(cOut.length()-1))&&(cOut.charAt(i)==cOut.charAt(i+1)))
			{
				count++;
				i++;
			}
			if(count ==1)
				cList.add(cOut.substring(i, i+1));
			else
				cList.add("("+count+" "+cOut.charAt(i)+")");
			
			count = 1;
			//System.out.println("ADD" + cList.get(cList.size()-1));
		}
		System.out.print("3: ");	
		cOut  = "";
		for(int i = 0; i < cList.size(); i++)
			cOut += cList.get(i)+" ";	
		System.out.println("'(" + cOut.substring(0,cOut.length()-1) + ")");
		
		//4
		String dOut = "";
		Integer deleteFactor = (d.charAt(d.length()-2)-'0');
		ArrayList<String> dList = new ArrayList<String>();
		for(int i = 2; i < d.length()-2; i++)
			dOut+=d.charAt(i);
		
		for(int i = 0; i < dOut.length(); i++)
		{
			if(dOut.charAt(i) == '(')
			{
				dList.add(dOut.substring(i+1, i+4));
				i+=4;
				//System.out.println("ADD: " + dList.get(dList.size()-1));
			}
		}
		dList.add(deleteFactor.toString());
		for(int i = 1; i < dList.size()+1; i++)
		{
			if((i%deleteFactor)==0)
			{
				dList.set(i-1, "");
				//System.out.println("DELETE:" + (i-1));
			}
		}
		dOut  = "";
		for(int i = 0; i < dList.size(); i++)
		{
			if(i == dList.size()-1)
			{
				if(dList.get(i)=="")
				{
					dOut = dOut.substring(0,dOut.length()-1);
				}
				dOut += dList.get(i);
			}else if(dList.get(i) != "")
			{
				dOut += "(" + dList.get(i) + ") ";
			}
		}		
		System.out.println("4: "  + "'(" + dOut + ")");	
		
		//5
		String eOut = "";
		Integer splitFactor = (e.charAt(e.length()-2)-'0');
		ArrayList<String> eList = new ArrayList<String>();
		for(int i = 2; i < e.length()-2; i++)
			eOut+=e.charAt(i);
		
		for(int i = 0; i < eOut.length(); i++)
		{
			if(eOut.charAt(i) == '(')
			{
				eList.add(eOut.substring(i+1, i+4));
				i+=4;
				//System.out.println("ADD: " + dList.get(dList.size()-1));
			}
		}
		eOut  = "";
		eList.add(splitFactor.toString());
		for(int i = 0; i < eList.size(); i++)
		{
			if(i == splitFactor)
			{
				eOut = eOut.substring(0, eOut.length()-1);
				eOut += ") '(";
			}
			if(i == eList.size()-1)
			{
				eOut += eList.get(i);
			}else if(eList.get(i) != "")
			{
				eOut += "(" + eList.get(i) + ") ";
			}
		}		
		System.out.println("5: "  + "'(" + eOut + ")");	
	}
}
