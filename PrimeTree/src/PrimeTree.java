
public class PrimeTree {

	public static int isPrime(int x)
	{
		if(x==1){
			return 0;
		}
		for(int i = 2; i < x; i++){
			if((x%i) == 0)
			{
				return 0;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height;
		int seed;
		height = 5;
		seed = 23;
		
		int output = seed;
				
		for(int a = 1; a < height+1; a++){
			for(int b = 0; b < a; b++){
				if(isPrime(output)==1){
					System.out.print(output);
					System.out.print("  ");
				}else{
					System.out.print("*   ");
				}
				output++;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		output= seed;
		for(int a = 1; a < height+1; a++){
			for(int b = 0; b < a; b++){
				if(isPrime(output)==1){
					System.out.print(output);
					System.out.print("  ");
				}else{
					while(isPrime(output)==0){
						output++;
					}
					System.out.print(output);
					System.out.print("  ");
				}
				output++;
			}
			System.out.println();
		}
		
	}
}
