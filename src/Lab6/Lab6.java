
		// This Lab requires you to program a simple game of Tic Tac Toe
	
		// Rules:  
		//		- Tic Tac Toe is a 2-player game played on a 3x3 grid.  
		//
		//		- One player usually plays "X"s and the other player plays "O"s.
		//
		// 		- In our version of the game, "X"s will always start.
		//
		//		- Players will alternate turns.
		//
		// 		- The game will end when one of the conditions is true:
		//				1. A player gets three squares in a row 
		//				2. A player gets three squares in a column
		//				3. A player gets three squares in either diagonal
		//				4. Every square is filled in, but no player has achieved 
		//					conditions 1,2, or 3 as described above --> A Draw!
		//
		//		- A player can win on turn 5, 6, 7, 8, or 9 (start checking for winners on or before turn 5)
		//
		//		- Error checking of input is not necessary here, but will make this game much more
		//				robust.  If you choose to implement this, get the game working first, and then
		//				add a check of the input to make sure that it's an Integer from 1 to 9.
		//
		//		- Use the Scanner to input the users choice of square -- one suggestion is  
		//				to create numbers within the square, and then have the user choose 
		//				that integer (1-9) to choose the location.
		//
		//		- One way to display the game board would be as follows:
		//				+---+---+---+       to		+---+---+---+		+---+---+---+		+---+---+---+
		//				| 1 | 2 | 3 |	   find		|---|---|---|		| | | | | | |		| \ |   | / |
		//				+---+---+---+	   a win	+---+---+---+		+---+---+---+		+---+---+---+
		//				| 4 | 5 | 6 |	-- look-->	|---|---|---|	&	| | | | | | |   & 	|   | X |   |
		//				+---+---+---+	 at these	+---+---+---+		+---+---+---+		+---+---+---+
		//				| 7 | 8 | 9 |	8 patterns	|---|---|---|		| | | | | | |		| / |   | \ |
		//				+---+---+---+		        +---+---+---+	     +---+---+---
		//		1. Create a class with a main method -- this Lab can be implemented in just one class.
		//				
		//				Alternatively, you could create an object with it's own methods. 
		//				(e.g. GameBoard.java)
		//


package Lab6;

import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		System.out.println(" Tik Tac Toe ");
		
		// instantiate gamebaord
		GameBoard gameBoard = new GameBoard();
		gameBoard.start();
		gameBoard.showBoard();
		
		String winner = "";
		String player = "X"; // set to X because X plays first
		int allSquares = 1;
		int squareNumber;
		
		Scanner in = new Scanner(System.in);
		
	
		
		// Implement rules

		// winner if horizontal, or vertical, or diagonal is matched with x's or o's
while(winner.equals("") && allSquares <=9) { // keep going until we reach a winner or the # squares is filled
	System.out.println("\n Player, "+player+" ,please choose a square to place an X/O");
	String readInput = in.nextLine();
	squareNumber = Integer.valueOf(readInput);
	
	if(squareNumber >0 && squareNumber <=9) { // if valid play
		if(gameBoard.ifValidSetSquare(squareNumber, readInput, player)) {
			if(player.equals("X")) {
				player = "O"; //switch to next player
			}else {
				player = "X"; // if O and valid play we switch to X
			}
			allSquares++;
			gameBoard.showBoard();
			winner = gameBoard.checkWinStatus();
		}else {
			System.out.println("Square has already been filled or DNE");
		}
		
	}

	
}

System.out.println("============");
System.out.println("Round Over!");
if(winner.equals("draw")) {
	System.out.println("This game is a "+winner+"!");
}else {
	System.out.println("Player "+winner+" won this round!");
}

in.close();

	}

}
