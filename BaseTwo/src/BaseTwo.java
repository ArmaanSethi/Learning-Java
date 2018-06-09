import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;


public class BaseTwo {
	static int getBaseTen(ArrayList<Integer> a)
	{
		int temp = 1;
		int x = 0;
		for(int i = 0; i < a.size(); i++)
		{
			temp = 1;
			for(int j = 0; j < a.size()-i-1; j++)
			{
				temp*=2;
			}
			System.out.println("Temp: " + temp);
			if(a.get(i) == 1)
			{
				x+=temp;
			}
		}
		
		System.out.println("X: " + x);
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		
		Scanner in = new Scanner(System.in);
		int baseTen = in.nextInt();
		String baseTwo = in.next();
		for(int i = 0; i < baseTwo.length(); i++)
			num2.add(baseTwo.charAt(i)-'0');
		
			
		System.out.println("Input: " + baseTen + " " + num2);
		
		int converted = 0;
		converted = getBaseTen(num2);

	}

}
