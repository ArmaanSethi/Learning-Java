
public class ACSLlandINT {
	public ACSLlandINT(char startingCity, char endingCity, char vehicle, char road, double gasoline)
	{
	
		int[] city = new int[]{450,140,120,320,250,80};
		int totalMiles = 0;
		for(int i = (startingCity-'A') ; i < ((startingCity - 'A') + (endingCity-startingCity)); i++)
		{
			totalMiles += city[i];
		}
		System.out.print( totalMiles + ", ");
		//TOTAL TIME
		int mph = 0;
		if(road == 'I')
			mph = 65;
		else if (road == 'H')
			mph = 60;
		else if (road == 'M')
			mph = 55;
		else if (road == 'S')
			mph = 45;
		
		int hours,minutes;
		double totalMinutes;
		totalMinutes = 60*((double)totalMiles/(double)mph);
		if(totalMinutes - (int)(totalMinutes) >= .5)
			totalMinutes++;
		hours = (int) ((totalMinutes)/60); 
		minutes = (int)((totalMinutes)%60);
		//System.out.println("Hours :" + hours + " Minutes: " + minutes);
		if(hours < 10)
			System.out.print(0);
		System.out.print(hours + ":");
		if(minutes < 10)
			System.out.print(0);
		System.out.print(minutes + ", ");
		
		//TOTAL COST
		int mpg = 1;
		if(vehicle == 'C')
			mpg = 28;
		else if(vehicle == 'M')
			mpg = 25;
		else if(vehicle == 'F')
			mpg = 22;
		else if (vehicle == 'V')
			mpg = 20;
		
		double price = ((double)totalMiles/(double)mpg)*gasoline;
		int dollars = (int)price;
		double frac = price - dollars;
		int cents = (int)((frac * 100) + 0.5);
		System.out.print("$" + dollars + ".");
		if(cents < 10)
			System.out.print(0);
		
		System.out.println(cents);	
	}
}
