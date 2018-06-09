
public class Poker2Card {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c1 = new Card(17);
		Card c2 = new Card(16);
		System.out.println("PLAYER 1:  " + c1 + "     "  + c2 + "      " + c1.compareTo(c2));
		System.out.println();
		Card c3 = new Card(30);
		Card c4 = new Card(35);
		System.out.println("PLAYER 2:  " + c3 + "     "  + c4 + "      " + c3.compareTo(c4));
		System.out.println();
		
		if(c1.getRank() > c3.getRank()){
			System.out.println("          PLAYER 1 WINS!");
		}
		else if(c1.getRank() < c3.getRank()){
			System.out.println("          PLAYER 2 WINS!");
		}
		else
		{
			if(c1.getHighCard() > c3.getHighCard()){
				System.out.println("          PLAYER 1 WINS!");
			}else if(c1.getHighCard() < c3.getHighCard()){
				System.out.println("          PLAYER 2 WINS!");
			}else{
				System.out.println("          Tie");
			}
		}
	}
}
