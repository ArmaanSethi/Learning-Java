
public class ACSLlandSR {
	   public ACSLlandSR(char startingCity, char endingCity, int hour1, char ampm1, int hour2, char ampm2, int speed1, int speed2)
	   {
		   System.out.println("Input: " + startingCity + "," + endingCity + "," +  hour1 + "," +  ampm1 + "," +  hour2 + "," +  ampm2 + "," +  speed1 + "," +  speed2);
		  //TOTAL MILES
		   int[] city = new int[]{450,140,125, 365, 250, 160, 380, 235, 0, 320};
		   double totalMiles = 0;
		   for(int i = (startingCity-'A') ; i < ((startingCity - 'A') + (endingCity-startingCity)); i++)
			   totalMiles += city[i];
		   System.out.print( "totalMiles: " + totalMiles + ", ");
		  //DIFFERENCE IN TIME
		   if(ampm1 == 'P')
			   hour1+=12;
		   if(ampm2 == 'P')
			   hour2+=12;
		   
		   if(hour1 == 12)
			   hour1 = 0;
		   if(hour2 == 12)
			   hour2 = 0;
		   if(hour1 == 24)			
			   hour1 = 12;
		   if(hour2 == 24)
			   hour2 = 12;
		   
		   
		   double timeDifference;
		   
		   if(Math.abs(hour1-hour2) > 12)
			   timeDifference = 24 - Math.abs(hour1-hour2);			   
		   else
			   timeDifference = Math.abs(hour1-hour2);
		   
		   
		   //timeDifference*=60;
		   System.out.println("timeD: " + timeDifference);
		   double totalMinutes = 0;
		   double otherTime = 0;
		   
		   //CALCULATE MINUTES
		   if(Math.abs(hour1-hour2)>12){
			   if(hour1 > hour2){//Car 1 leaves First
				   if((totalMiles - (timeDifference*speed1)) < 0)
				   {
					   totalMinutes = (totalMiles/speed1)*60;
				   }else{
					   totalMiles = totalMiles - (timeDifference*speed1);
					   otherTime = totalMiles /(speed1+speed2);
					   System.out.println("tM: " + totalMiles + "   oT: " + otherTime*60 );
					   totalMinutes = (timeDifference + otherTime)*60;
				   }
			   }else{//Car 2 leaves first
				   if((totalMiles - (timeDifference*speed2)) < 0)
				   {
					   totalMinutes = 0;
				   }else{
					   totalMiles = totalMiles - (timeDifference*speed2);
					   otherTime = totalMiles /(speed1+speed2);
					   System.out.println("tM: " + totalMiles + "   oT: " + otherTime*60 );
					   totalMinutes = (otherTime)*60;
				   }
			   }
		   }else{
			   if(hour1 < hour2){//Car 1 leaves first
				   if((totalMiles - (timeDifference*speed1)) < 0)
				   {
					   totalMinutes = (totalMiles/speed1)*60;
				   }else{
					   totalMiles = totalMiles - (timeDifference*speed1);
					   otherTime = totalMiles /(speed1+speed2);
					   System.out.println("tM: " + totalMiles + "   oT: " + otherTime*60 );
					   totalMinutes = (timeDifference + otherTime)*60;
				   }
			   }else{//Car 2 leaves first
				   if((totalMiles - (timeDifference*speed2)) < 0)
				   {
					   totalMinutes = 0;
				   }else{
					   totalMiles = totalMiles - (timeDifference*speed2);
					   otherTime = totalMiles /(speed1+speed2);
					   System.out.println("tM: " + totalMiles + "   oT: " + otherTime*60 );
					   totalMinutes = (otherTime)*60;
				   }
			   }
		   }
		   
		   //HOURS::MINUTES
		   System.out.println();
		   int hours;
		   int minutes;
		   
		   	
			if(totalMinutes - (int)(totalMinutes) >= .5)
				totalMinutes++;
			hours = (int) ((totalMinutes)/60); 
			minutes = (int)((totalMinutes)%60);
			//System.out.println("Hours :" + hours + " Minutes: " + minutes);
			System.out.print(hours + ":");
			if(minutes < 10)
				System.out.print(0);
			System.out.print(minutes + ", ");

		   System.out.println();
	   }

}
