package Lab6;

import java.util.Arrays;

public class GameBoard {
	//		2. You will need to declare a gameBoard.  
	//
	//				As shown above, Tic Tac Toe is played on a 3x3 grid that has 9 spaces. 
	//
	//					a. One suggestion is to create an array of length 9 to represent the board:
	//
	//						For example:  String[] gameBoard = new String[9]; 
	//
	//							i. Just remember that arrays are 0 based, so to access the grid, 
	//							the index would go from 0-8.  
	//
	//							ii. Wins can occur in 8 ways (see above).
	//								For example: A horizontal win would be found by 
	//								looking at the contents of: 
	//									gameBoard[0] & gameBoard[1] & gameBoard[2] 
	//									gameBoard[3] & gameBoard[4] & gameBoard[5] 
	//									gameBoard[6] & gameBoard[7] & gameBoard[8] 
	
	String[] gameBoard = new String[9]; // Game board has 9 spaces
	public void start() { // initialize game board
		
		for (int i = 1; i <=9; i++) {
			this.gameBoard[i-1] = String.valueOf(i);
		}
	}

	
//horisontal win
//								gameBoard[0] & gameBoard[1] & gameBoard[2] 
//								gameBoard[3] & gameBoard[4] & gameBoard[5] 
//								gameBoard[6] & gameBoard[7] & gameBoard[8] 
//										
////vertical win
//								gameBoard[0] & gameBoard[3] & gameBoard[5] 
//								gameBoard[1] & gameBoard[4] & gameBoard[6] 
//								gameBoard[2] & gameBoard[5] & gameBoard[7] 
//
//// diagonal win
//								gameBoard[0] & gameBoard[4] & gameBoard[7] // \
//								gameBoard[2] & gameBoard[4] & gameBoard[5] // /	
	
	
	public void showBoard() {
		System.out.println("+---+---+---+");
		System.out.println("| "+ this.gameBoard[0] +" | " +this.gameBoard[1]+" | "+ this.gameBoard[2] +  " | ");
		System.out.println("+---+---+---+");
		System.out.println("| "+ this.gameBoard[3] +" | " +this.gameBoard[4]+" | "+ this.gameBoard[5] +  " | ");
		System.out.println("+---+---+---+");
		System.out.println("| "+ this.gameBoard[6] +" | " +this.gameBoard[7]+" | "+ this.gameBoard[8] +  " | ");
		System.out.println("+---+---+---+");
	}

	

	public String checkWinStatus() {
	for (int pos = 0; pos <8; pos++) { // pisitions
		String winningCombo = "";
		switch(pos) {
		case 0: winningCombo = this.gameBoard[0] + this.gameBoard[1] + this.gameBoard[2] ;
		break;
		case 1: winningCombo = this.gameBoard[3] + this.gameBoard[4] + this.gameBoard[5] ;
		break;
		case 2: winningCombo = this.gameBoard[6] + this.gameBoard[7] + this.gameBoard[8] ;
		break;
		case 3: winningCombo = this.gameBoard[0] + this.gameBoard[3] + this.gameBoard[6] ;
		break;
		case 4: winningCombo = this.gameBoard[1] + this.gameBoard[4] + this.gameBoard[7] ;
		break;
		case 5: winningCombo = this.gameBoard[2] + this.gameBoard[5] + this.gameBoard[8] ;
		break;
		case 6: winningCombo = this.gameBoard[0] + this.gameBoard[4] + this.gameBoard[8] ;
		break;
		case 7: winningCombo = this.gameBoard[2] + this.gameBoard[4] + this.gameBoard[6] ;
	break;
		}
		if(winningCombo.equals("XXX")) {
			return "X";
		}else if(winningCombo.equals("OOO")) {
			return "O";
		}
	}
	
	for (int pos = 1; pos <= 9; pos++) {
		if(Arrays.asList(this.gameBoard).contains(String.valueOf(pos))) {
			break;
		}else if(pos == 9) { // last position
			return "draw";
		}

	}

	
	
//	public String isWinner() {
//		//horisontal win
//		if()
	
//	gameBoard[3] & gameBoard[4] & gameBoard[5] 
//			gameBoard[6] & gameBoard[7] & gameBoard[8] 

////				
//////vertical win
////		gameBoard[0] & gameBoard[3] & gameBoard[5] 
////		gameBoard[1] & gameBoard[4] & gameBoard[6] 
////		gameBoard[2] & gameBoard[5] & gameBoard[7] 
////
//////diagonal win
////		gameBoard[0] & gameBoard[4] & gameBoard[7] // \
////		gameBoard[2] & gameBoard[4] & gameBoard[5] // /	
//		return "X is a winnner!";
//	}
	return ""; // no winner and no draw
}
	
	public boolean ifValidSetSquare(int squareNumber, String input, String player) {
		// if square is open
			if (this.gameBoard[squareNumber-1].equals(String.valueOf(input))) { // if the board contains the input
				this.gameBoard[squareNumber-1] = player; // set = to X or O
				return true;
			}else {
			return false;
			}
		}
	
}
