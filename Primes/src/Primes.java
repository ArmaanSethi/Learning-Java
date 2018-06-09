
public class Primes {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long  x = 2147483647;
		long x = 13;
		int i = 2;
		int counter = 0;
		int[] output = new int[]{0,0,0,0,0,0,0,0,0,0};
		while((x > 1)&&(counter < 10))
		{
			if((x%i)==0){
				output[counter]=i;
				counter++;
			}
			while((x%i)==0)
			{
				x = x/i;
			}
			i++;
		}
		System.out.print("PRIME:   " );
		for(int a = 0; a < output.length; a++)
			if(output[a] != 0)
				System.out.print(output[a] + "  ");
		
	}
}