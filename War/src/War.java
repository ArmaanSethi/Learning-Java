
public class War {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Hand h1 = new Hand(6,7,1,1,8,2,11,0,2,1);
		//Hand h2 = new Hand(3,3,3,3,8,10,7,8,7,4);
		Hand h1 = new Hand();
		Hand h2 = new Hand();
		System.out.println(h1);
		System.out.println(h2);
		h1.Play(h2.getHand());
		System.out.println(h1.moves);
	}

}
