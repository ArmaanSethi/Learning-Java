import java.util.ArrayList;


public class ACSLIsolaSR {
	int board[][] = new int[7][7];
	int tempBoard[][] = new int[7][7];
	int x, y;
	
	ArrayList<Integer> open = new ArrayList<Integer>();
	ArrayList<Integer> gone = new ArrayList<Integer>();
	ArrayList<Integer> temp = new ArrayList<Integer>();
	ArrayList<Integer> path = new ArrayList<Integer>();

	int isValid(int x, int y)
	{
		if((x < 7)&&(y < 7)&&(x>=0)&&(y>=0)&&(board[x][y]!=-1))
			return 1;
		else
			return 0;
	}
	
	int valueAt(int x, int y)
	{
		return board[x][y];
	}
	public void output()
	{
		for(int i = 0; i < temp.size(); i++)
			System.out.print(temp.get(i) + " ");
	}
	public int checkPath()
	{
		for(int i=0; i<open.size(); i++)
			if(checktemp(open.get(i))==0)
				return 0;
		
		return 1;
	}
	public int checktemp(int a)
	{
		for(int i = 0; i<temp.size(); i++)
			if(temp.get(i).intValue() == a)
				return 1;
		
		return 0;
	}
	public int checkRemoved(int a)
	{
		for(int i = 0; i<gone.size(); i++)
			if(gone.get(i).intValue() == a)
				return 1;
		
		return 0;
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
		Integer x1 = 0;
		do
		{
			int position = input.indexOf(',');
			System.out.println("Pos: " + position);
			String thing = input.substring(1,position);
			input = input.substring(position+1, input.length());
			System.out.println(input);
			x1 = Integer.valueOf(thing);
			numbers.add(x1);
			System.out.println("X: " + (x1-1)/7 + "Y: " + (x1-1)%7);
			if(x1!=0)
			{
				board[(x1.intValue()-1)/7][(x1.intValue()-1)%7] = -1;
			}
		}while (x1 != 0);
		
		for(int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}

		for(int i = 0; i < numbers.size()-1; i++)
		{
			gone.add(numbers.get(i));
			System.out.println("Num " + i + ": " + numbers.get(i));
		}
		
		
		x = gone.get(0);
		y = gone.get(1);
		//if(checkRemoved(45)){System.out.println("True");
		if((x+7<50)&&(checkRemoved(x+7)==0))
			open.add(new Integer(x+7));
		
		if((x-7>0)&&(checkRemoved(x-7)==0))
			open.add(new Integer(x-7));
		
		if((x+1<50)&&(checkRemoved(x+1)==0)&&(x%7 != 0))
			open.add(new Integer(x+1));
		
		if((x-1>0)&&(checkRemoved(x-1)==0)&&((x-1)%7 != 0))
			open.add(new Integer(x-1));
		
		if((x+8<50)&&(checkRemoved(x+8)==0)&&(x%7 != 0))
			open.add(new Integer(x+8));
		
		if((x-8>0)&&(checkRemoved(x-8)==0)&&((x-1)%7 != 0))
			open.add(new Integer(x-8));
		
		if((x+6<50)&&(checkRemoved(x+6)==0)&&((x-1)%7 != 0))
			open.add(new Integer(x+6));
		
		if((x-6>0)&&(checkRemoved(x-6)==0)&&(x%7 != 0))
			open.add(new Integer(x-6));
		
		//System.out.println(open);
		int ytemp = y;
		boolean good = false;
		while((ytemp+7<50)&&(checkRemoved(ytemp+7)==0)&&(ytemp+7!=x))
		{
			ytemp+=7;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp-7>0)&&(checkRemoved(ytemp-7)==0)&&(ytemp-7!=x))
		{
			ytemp-=7;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp+1<50)&&(checkRemoved(ytemp+1)==0)&&(ytemp+1!=x)&&((ytemp)%7 != 0))
		{
			ytemp+=1;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp-1>0)&&(checkRemoved(ytemp-1)==0)&&(ytemp-1!=x)&&((ytemp-1)%7 != 0))
		{
			ytemp-=1;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp+8<50)&&(checkRemoved(ytemp+8)==0)&&(ytemp+8!=x)&&((ytemp)%7 != 0))
		{
			ytemp+=8;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp-8>0)&&(checkRemoved(ytemp-8)==0)&&(ytemp-8!=x)&&((ytemp-1)%7 != 0))
		{
			ytemp-=8;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			//System.out.println(temp);
		}
		temp.clear();
		ytemp = y;
		while((ytemp+6<50)&&(checkRemoved(ytemp+6)==0)&&(ytemp+6!=x)&&((ytemp-1)%7 != 0))
		{
			ytemp+=6;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			output();
		}
		temp.clear();
		ytemp = y;
		while((ytemp-6>0)&&(checkRemoved(ytemp-6)==0)&&(ytemp-6!=x)&&((ytemp)%7 != 0))
		{
			ytemp-=6;
			temp.add(new Integer(ytemp));
		}
		if(checkPath()==1)
		{
			good = true;
			//System.out.println(temp);
		}
		if(good == false)
		{
			System.out.println("NONE");
		}
			//System.out.println(output);
	}

}
