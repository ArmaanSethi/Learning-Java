import java.util.Random;


public class Card {
	
	public int value;
	public int suit = 0;
	
	public Card(){
		Random r = new Random();
		int num = r.nextInt(52);
		value = new Integer(num%13);
		if(value == 0)
			value = 13;
		
		suit = num/13;
	}
	public Card(int x){
		value = x%13;
		suit = x/13;
		if(value == 0)
			value = 13;
	}
	public int getValue(){ 
		return value;
	}
	public int getSuit(){
		return suit;
	}
	public String toString(){
		String output = "";
		if(value == 13)
			output += "A";
		else if(value == 12)
			output += "K";
		else if(value == 11)
			output += "Q";
		else if(value == 10)
			output += "J";
		else 
			output +=  (new Integer(value+1)).toString();
		
		if(suit < 1)
			output += "C";
		else if(suit < 2)
			output += "D";
		else if(suit < 3)
			output += "H";
		else if(suit < 4)
			output += "S";
					
		return output;			
	}

}
