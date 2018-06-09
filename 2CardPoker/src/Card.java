import java.util.Random;

public class Card{
	public int highCard = 0;
	public int rank = 0;
	public Integer value;
	public int suit = 0;
	
	public Card(){
		Random r = new Random();
		int num = r.nextInt(52);
		value = new Integer(num%13);
		suit = num/13;
	}
	public Card(int x){
		value = x%13;
		suit = x/13;
	}
	public int getRank(){
		return rank;
	}
	public int getHighCard(){
		return highCard;
	}
	public int getValue(){ 
		return value.intValue();
	}
	public int getSuit(){
		return suit;
	}
	public String compareTo(Card c2){
		if(value.intValue() > c2.getValue()){
			highCard = value.intValue();
		}else{
			highCard = c2.getValue();
		}
		if(suit == c2.getSuit()){//suit
			if((value.intValue() == c2.getValue()+1)||(value.intValue() == c2.getValue()-1)){//straight
				rank=5;
				return("SRAIGHT FLUSH");
			}
			else{ //flush
				rank=2;
				return("FLUSH");
			}
		}
		else if((value.intValue() == c2.getValue()+1)||(value.intValue() == c2.getValue()-1)){
			rank=3;
			return("STRAIGHT");
		}
		else if(value.intValue() == c2.getValue()){//pair
			rank=4;
			return("PAIR");
		}
		else{ //high card
			rank=1;
			return("HIGH CARD");
		}
	}
	public String toString(){
		String output = "";
		if(value.intValue() == 0)
			output += "A";
		else if( value.intValue() < 10)
			output +=  (new Integer(value.intValue()+1)).toString();
		else if(value.intValue() == 10)
			output += "J";
		else if(value.intValue() == 11)
			output += "Q";
		else if(value.intValue() == 12)
			output += "K";
				
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