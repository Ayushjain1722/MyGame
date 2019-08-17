package Game;

public class Board 
{
	private char board[][];
	private int boardSize = 3;
	private char p1Symbol;
	char p2Symbol;
	private int count;
	
	public Board(char p1Symbol,char p2Symbol)
	{
		board = new char [boardSize][boardSize];
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				board[i][j]=' ';
				
			}
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
	
	public String move(char symbol,int x,int y)
	{
		if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ')
			return "Invalid";
		
		board[x][y] = symbol;
		count++;
		//Check Row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
		{
			return symbol == p1Symbol ? "Player 1 Wins!!": "Player 2 Wins!!";
		}
		//Check Column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
		{
			return symbol == p1Symbol ? "Player 1 Wins!!": "Player 2 Wins!!";
		}
		//Check Diagonals
		int check1=0;
		int check2=0;
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				if(i==j)
					if(board[i][j]==symbol)
						check1++;
				if(i+j==boardSize-1)
					if(board[i][j]==symbol)
						check2++;
			}
		}
		if(check1==boardSize)
		{
			return symbol == p1Symbol? "Player 1 Wins!!" : "Player 2 Wins!!";
		}
		else if(check2==boardSize)
		{
			return symbol == p1Symbol?"Player 1 Wins!!": "Player 2 Wins!!";
		}
		if(count==boardSize*boardSize)
			return "Draw";
		else
			return "Incomplete";
	}

	public void print() 
	{
		System.out.println("----------------------");
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("----------------------");
	}
}