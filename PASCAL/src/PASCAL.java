//Armaan Sethi
//Period 3. 1/14/15.
//AP Computer Science Midterm Program
//Mr.Potter
public class PASCAL {
	public static long factorial(int x)
	{
		long answer=1;
		if(x!= 0)
		{
			for(int i = 1; i < x+1; i++)
				answer *= i;
		}
		return answer;		
	}
	public static long choose(int n, int k)
	{
		long answer = (factorial(n))/(factorial(k)*factorial(n-k));
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height;
		height = 10;		
		for(int a = 0; a < height; a++){
			for(int b = 0; b < a+1; b++){
				System.out.print(choose(a,b) + "  ");
			}
			System.out.println();
		}
	}

}
