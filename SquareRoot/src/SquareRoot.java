import java.util.Random;
public class SquareRoot {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Double x = new Double(r.nextInt(100));
		System.out.println("Int: " + x + "        Root: " + Math.sqrt(x));
		x= Math.sqrt(x);
		String xString = x.toString() + "0";
		int i = 0;
		while(xString.indexOf(xString.substring(i,i+1))== i)
		{
			System.out.print(xString.substring(i,i+1));
			i++;
		}
		System.out.println(xString.substring(i, i+1));
	}
}
