import java.util.ArrayList;

public class Hand {
	ArrayList<Card> h1 = new ArrayList<Card>();
	public int game = 0;
	int moves = 0;
	public ArrayList<Card> pile = new ArrayList<Card>();
		
	public Hand()
	{
		for(int i = 0; i < 10; i++)
			h1.add(new Card());
	}
	public Hand(int x)
	{
		for(int i = 0; i < x; i++)
			h1.add(new Card());
	}
	public Hand(int x0, int x1,int x2,int x3,int x4,int x5,int x6,int x7,int x8,int x9)
	{
		h1.add(new Card(x0));
		h1.add(new Card(x1));
		h1.add(new Card(x2));
		h1.add(new Card(x3));
		h1.add(new Card(x4));
		h1.add(new Card(x5));
		h1.add(new Card(x6));
		h1.add(new Card(x7));
		h1.add(new Card(x8));
		h1.add(new Card(x9));
	}
	public ArrayList<Card> getHand()
	{
		return h1;
	}
	public void Tie(ArrayList<Card> h1, ArrayList<Card> h2)
	{
		System.out.println("WAR");
		
		int counter = 0;
		
		while((h1.size() > 1) && (h2.size() > 1) && (counter < 4))
		{
			pile.add(h1.remove(0));
			pile.add(h2.remove(0));
			counter++;
		}
		for(int i = 0; i< pile.size(); i++)
		{
			System.out.println("Pile: " + pile.get(i));
		}
		int a = pile.size();
		if(h1.get(0).getValue() > ((Card) h2.get(0)).getValue())
		{
			System.out.println("Pile Size: " + pile.size());
			for(int i = 0; i < a; i++)
				h1.add(pile.remove(0));
			
			h1.add(h1.remove(0));
			h1.add(h2.remove(0));
		}else if(((Card) h2.get(0)).getValue() > (h1.get(0).getValue())) 
		{
			System.out.println("Pile Size: " + pile.size());
			for(int i = 0; i < a; i++)
				h2.add(pile.remove(0));
			
			h2.add(h1.remove(0));
			h2.add(h2.remove(0));
		}else
		{
			if((h1.size()==1)||(h2.size()==1))
			{
				if(h1.size()==1)
					System.out.println("Player 1 Wins! Out of Cards");
				else
					System.out.println("Player 2 Wins! Out of Cards");
				game = 1;
			}else
			{
				Tie(h1, h2);
			}
		}
	}
	public void Play(ArrayList<Card> h2)
	{
		while((h1.size() > 0) && (h2.size() > 0) && (game == 0))
		{
			if(h1.get(0).getValue() > ((Card) h2.get(0)).getValue())
			{
				h1.add(h1.remove(0));
				h1.add((Card) h2.remove(0));			
			}else if(((Card) h2.get(0)).getValue() > (h1.get(0).getValue())) 
			{
				h2.add(h1.remove(0));
				h2.add((Card) h2.remove(0));			
			}else
			{
				Tie(h1, h2);
			}
			System.out.println();
			System.out.println("H1: " + h1 + ":       " + h1.size());
			System.out.println("H2: " + h2 + ":       " + h2.size());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(h1.size()==0)
			System.out.println("Player 2  WINS!");
		else
			System.out.println("Player 1  WINS!");
	}
	public String toString()
	{
		String output = "";
		for(int i = 0; i < h1.size(); i++)
			output+= h1.get(i) + " ";
		return output;
	}

}
