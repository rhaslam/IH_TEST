import java.util.Scanner;

public class TicTacToe {

	public char[][] matrix = new char[3][3];
	
	public static final char blank = ' ';
	public static final char X = 'X';
	public static final char O = 'O';			
	
	public TicTacToe()
	{
		instructions();
		// Initialize matrix (board) to blanks
		for (int row= 0; row <3; row++)
		{
			for (int column = 0; column < 3; column++)
			{
				matrix[row][column] = blank;
			}
		}
	}
	
	private static void instructions()
	{
		System.out.println("The game is played in a 3x3 matrix with cells assigned these letters.");
		System.out.println("1 | 2 | 3");
		System.out.println("4 | 5 | 6");
		System.out.println("7 | 8 | 9");
		System.out.println("X starts each game");
	}
	
	/*
	 * Play the game
	 */
	public void playGame()
	{
		boolean stopPlay = false;
		boolean gameDone = false;
		boolean Xturn = true;
		char currentValue = 'X';
		Scanner sc = new Scanner(System.in);
		while (! stopPlay)
		{
			while (! gameDone)
			{
				displayStatus();
				if (Xturn)
				{
					System.out.println("X select your cell (1-9) :");
					currentValue = 'X';
					Xturn = false;
				}
				else
				{
					System.out.println("O select your cell (1-9) :");
					currentValue = 'O';
					Xturn = true;
				}

				char loc = sc.next().charAt(0);
				
				switch (loc)
				{
					case '1':
						if (matrix[0][0] == blank)
						{
							matrix[0][0] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[0][0]);
						}
						break;
					case '2':
						if (matrix[0][1] == blank)
						{
							matrix[0][1] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[0][1]);
						}
						break;
					case '3':
						if (matrix[0][2] == blank)
						{
							matrix[0][2] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[0][2]);
						}
						break;
					case '4':
						if (matrix[1][0] == blank)
						{
							matrix[1][0] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[1][0]);
						}
						break;
					case '5':
						if (matrix[1][1] == blank)
						{
							matrix[1][1] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[1][1]);
						}
						break;
					case '6':
						if (matrix[1][2] == blank)
						{
							matrix[1][2] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[1][2]);
						}
						break;
					case '7':
						if (matrix[2][0] == blank)
						{
							matrix[2][0] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[2][0]);
						}
						break;
					case '8':
						if (matrix[2][1] == blank)
						{
							matrix[2][1] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[2][1]);
						}
						break;
					case '9':
						if (matrix[2][2] == blank)
						{
							matrix[2][2] =  currentValue;
						}
						else 
						{
							System.out.printf("Poisiton is owned by %c", matrix[2][2]);
						}
						break;
			 
				}
				String winner = computeWinner(); 
				if (! winner.equals(" "))
				{
					System.out.println(winner + " wins the game");
					gameDone = true;
				}
			}
			System.out.println("Play again [y/n]: ");
			char again = sc.next().charAt(0);
			if (again != 'y' && again !='Y')
			{
				stopPlay = true;;
			}
		}
	}
	
	public String computeWinner()
	{
		// Any empty cells?
		boolean incomplete = false;
		for (int row = 0; row <3; row++)
		{
			for (int column = 0;  column < 3;column++)
			{
				if (matrix[row][column] == blank)
				{
					incomplete = true;
					break;
				}
			}
			if (incomplete)
			{
				break;
			}
		}
		if (!incomplete)
		{
			return("Cat");
		}

		// Row Winner
		String result = RowWinner();
		if (! result.equals(" "))
		{
			return result;
		}
		result = ColumnWinner();
		if (! result.equals(" "))
		{
			return result;
		}
		result = DiagonalWinner();
		if (! result.equals(" "))
		{
			return result;
		}
		return " ";
	}
	

	public String RowWinner()
	{
		for (int row = 0; row < 3; row++)
		{
			if (matrix[row][0] == matrix[row][1] && matrix[row][1] == matrix[row][2])
			{
				if(matrix[row][0] != blank)
				{
					return String.valueOf(matrix[row][0]);
				}
			}
		}
		return " ";
	}

	public String ColumnWinner()
	{
		for (int column = 0; column < 3; column++)
		{
			if (matrix[0][column] == matrix[1][column] && matrix[1][column] == matrix[2][column])
			{
				if (matrix[0][column] != blank)
				{
					return String.valueOf(matrix[0][column]);
				}
			}
		}
		return " ";
	}
	
	public String DiagonalWinner()
	{
		// Check the forward diagonal
		if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2])
		{
			if (matrix[0][0] != blank)
			{
				return String.valueOf(matrix[0][0]);
			}
		}
		
		// Check the backward diagonal
		if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0])
		{
			if (matrix[2][0] != blank)
			{
				return String.valueOf(matrix[0][2]);
			}
		}
		return " ";
	}
	
	public void displayStatus()
	{
		System.out.println("Current board:");
		System.out.printf(" %c | %c | %c", matrix[0][0] , matrix[0][1] , matrix[0][2]);System.out.println();
		System.out.printf(" %c | %c | %c", matrix[1][0] , matrix[1][1] , matrix[1][2]);System.out.println();
		System.out.printf(" %c | %c | %c", matrix[2][0] , matrix[2][1] , matrix[2][2]);System.out.println();
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.playGame();
		
	}

}
