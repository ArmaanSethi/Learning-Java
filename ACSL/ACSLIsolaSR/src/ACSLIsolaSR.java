import java.util.ArrayList;


public class ACSLIsolaSR {
	int board[][] = new int[7][7];
	int temp[][] = new int[7][7];
	int noMove(int x, int y)
	{
		int yes = 0;
		//left
		//right
		//up
		//down
		//ul
		//ur
		//dl
		//dr
		return yes;
		
	}
	int isValid(int x, int y)
	{
		//int x = (n-1)/7;
		//int y = (n-1)%7;
		if((x < 7)&&(y < 7)&&(x>=0)&&(y>=0)&&(board[x][y]!=-1))
			return 1;
		else
			return 0;
	}
	
	int valueAt(int x, int y)
	{
		return board[x][y];
	}
	public ACSLIsolaSR(String input)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				board[i][j] = (j+1)+((i*7));
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}
		System.out.println(input);
		Integer x = 0;
		do
		{
			int position = input.indexOf(',');
			System.out.println("Pos: " + position);
			String thing = input.substring(1,position);
			input = input.substring(position+1, input.length());
			System.out.println(input);
			x = Integer.valueOf(thing);
			numbers.add(x);
			System.out.println("X: " + (x-1)/7 + "Y: " + (x-1)%7);
			if(x!=0)
			{
				board[(x.intValue()-1)/7][(x.intValue()-1)%7] = -1;
			}
		}while (x != 0);
		
		for(int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}

		for(int i = 0; i < numbers.size()-1; i++)
		{
			System.out.println("Num " + i + ": " + numbers.get(i));
		}
		int startingPos = numbers.get(1);
		int startingX = (startingPos-1)/7;
		int startingY = (startingPos-1)%7;
		int posX = startingX;
		int posY = startingY;
		int maxCount=0;
		int moveCount=0;
		String output = "";
		String places = "";
		System.out.println("Start");
		//Left
		moveCount=0;
		posX = startingX-1;
		posY = startingY;
		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posX--;
			moveCount++;
		}
		if(moveCount > maxCount)
		{
			output = places;
			maxCount = moveCount;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);
		places = "";
		//Right
		moveCount=0;
		posX = startingX+1;
		posY = startingY;
		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posX++;
			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		places = "";

		//Up
		moveCount=0;
		posX = startingX;
		posY = startingY+1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY++;
			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		places = "";

		//Down
		moveCount=0;
		posX = startingX;
		posY = startingY-1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY--;

			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		places = "";

		//UL
		moveCount=0;
		posX = startingX-1;
		posY = startingY+1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY++;
			posX--;

			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		places = "";

		//UR
		moveCount=0;
		posX = startingX+1;
		posY = startingY+1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY++;
			posX++;

			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		places = "";

		//DL
		moveCount=0;
		posX = startingX-1;
		posY = startingY-1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY--;
			posX--;

			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);


		//DR
		moveCount=0;
		posX = startingX+1;
		posY = startingY-1;

		while(isValid(posX,posY) == 1)
		{
			places += valueAt(posX,posY) + " ";

			posY--;
			posX++;

			moveCount++;
		}
		if(moveCount > maxCount)
		{
			maxCount = moveCount;
			output = places;
		}		
		System.out.println("maxCount:  " + maxCount + "places: " + places);

		System.out.println("END");
		//Output
		if(maxCount == 0)
		{
			System.out.println("NONE");
		}
		System.out.println(output);

	}
}
