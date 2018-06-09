import java.util.Scanner;


public class ThreeMensMorris {
	
	char[] board = new char[9];
	int moveNumber = 0;
	int winner = 0;
	char player = 'W';
	public ThreeMensMorris()
	{
		for(int i = 0; i < 9; i++)
		{
			board[i] = 'x';
		}
		board[1] = 'W';
		board[2] = 'W';
		board[5] = 'W';
		board[3] = 'B';
		board[4] = 'B';
		board[8] = 'B';
	}
	public void noMoreMoves()
	{
		//if(player == 'W')
		//{
			if((board[2] == 'B')&&(board[4]=='B')&&(board[6]=='B'))
			{
				if((board[0] == 'W')&&(board[1]=='W')&&(board[3]=='W'))
				{
					winner = 3;
				}
				if((board[5] == 'W')&&(board[7]=='W')&&(board[8]=='W'))
				{
					winner = 3;
				}
			}
			if((board[0] == 'B')&&(board[4]=='B')&&(board[8]=='B'))
			{
				if((board[1] == 'W')&&(board[2]=='W')&&(board[5]=='W'))
				{
					winner = 3;
				}
				if((board[3] == 'W')&&(board[6]=='W')&&(board[7]=='W'))
				{
					winner = 3;
				}
			}
		//}else if(player == 'B')
		//{
			if((board[2] == 'W')&&(board[4]=='W')&&(board[6]=='W'))
			{
				if((board[0] == 'B')&&(board[1]=='B')&&(board[3]=='B'))
				{
					winner = 3;
				}
				if((board[5] == 'B')&&(board[7]=='B')&&(board[8]=='B'))
				{
					winner = 3;
				}
			}
			if((board[0] == 'W')&&(board[4]=='W')&&(board[8]=='W'))
			{
				if((board[1] == 'B')&&(board[2]=='B')&&(board[5]=='B'))
				{
					winner = 3;
				}
				if((board[3] == 'B')&&(board[6]=='B')&&(board[7]=='B'))
				{
					winner = 3;
				}
			}
		//}
	}
	public int isWinner()
	{
		if((board[0] == 'W')&&(board[1] == 'W')&&(board[2] == 'W'))
		{
			return 1;
		}
		if((board[3] == 'W')&&(board[4] == 'W')&&(board[5] == 'W'))
		{
			return 1;
		}
		if((board[6] == 'W')&&(board[7] == 'W')&&(board[8] == 'W'))
		{
			return 1;
		}
		if((board[0] == 'W')&&(board[3] == 'W')&&(board[6] == 'W'))
		{
			return 1;
		}
		if((board[1] == 'W')&&(board[4] == 'W')&&(board[7] == 'W'))
		{
			return 1;
		}
		if((board[2] == 'W')&&(board[5] == 'W')&&(board[8] == 'W'))
		{
			return 1;
		}	
		if((board[0] == 'B')&&(board[1] == 'B')&&(board[2] == 'B'))
		{
			return 2;
		}
		if((board[3] == 'B')&&(board[4] == 'B')&&(board[5] == 'B'))
		{
			return 2;
		}
		if((board[6] == 'B')&&(board[7] == 'B')&&(board[8] == 'B'))
		{
			return 2;
		}
		if((board[0] == 'B')&&(board[3] == 'B')&&(board[6] == 'B'))
		{
			return 2;
		}
		if((board[1] == 'B')&&(board[4] == 'B')&&(board[7] == 'B'))
		{
			return 2;
		}
		if((board[2] == 'B')&&(board[5] == 'B')&&(board[8] == 'B'))
		{
			return 2;
		}		
		
		
		return 0;
	}
	public boolean isBeside(int pos1, int pos2)
	{
		if((pos1 == pos2+3)||(pos1 == pos2-3))
		{
			return true;
		}
		if((pos2 == pos1 + 1)&&(pos2 % 3 != 3))
		{
			return true;
		}
		if((pos2 == pos1 - 1)&&(pos1 % 3 != 0))
		{
			return true;
		}
		return false;
	}
	public void move(int pos1, int pos2)
	{
		board[pos1] = 'x';
		board[pos2] = player;
	}
	public void input()
	{
		int isGood = 0;
		while(isGood == 0)
		{
			Scanner in = new Scanner(System.in);
			int pos1 = in.nextInt()-1;
			int pos2 = in.nextInt()-1;
			if((isBeside(pos1,pos2)==true)&&(board[pos1] == player)&&(board[pos2]=='x'))
			{
				System.out.println("okay");	
				move(pos1,pos2);
				//moveNumber++;
				isGood = 1;
			}else
			{
				System.out.println("Not so okay");
			}
		}
	}
	public void output()
	{
		if(moveNumber%2==0)
		{
			player = 'W';
			System.out.println(player + " WHITE");
		}else
		{
			player = 'B';
			System.out.println(player + " BLACK");
		}
		for(int i = 0; i < 9; i++)
		{			
			if((i%3)==0)
			{
			System.out.println();
			}
			System.out.print(board[i] + " ");
		}System.out.println();
	}
	public void execute()
	{
		System.out.println();
		while(winner == 0)
		{
			noMoreMoves();
			output();
			input();
			winner = isWinner();
			moveNumber++;
			noMoreMoves();
			System.out.println("Winner " + winner);
		}
		output();
		if(winner == 1)
		{
			System.out.println("White Wins");
		}
		if(winner == 2)
		{
			System.out.println("Black Wins");
		}
		if(winner == 3)
		{
			System.out.println("Stalemate " + player + " cannot move");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeMensMorris m = new ThreeMensMorris();
		m.execute();
	}

}
