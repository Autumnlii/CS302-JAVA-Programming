
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Play2048)
// Files:            (list of source files)
// Semester:         CS302 Fall 2014
//
// Author:           (Qiuying Li)
// Email:            (qli243@wisc.edu)
// CS Login:         (qiuying)
// Lecturer's Name:  (Deb Deppeler)
// Lab Section:      (328)
//
///////////////////////////// 80 columns wide //////////////////////////////////
/**
 * Represents a card with a Suit and a CardValue.
 *
 * Bugs: none known
 *
 * @author       Qiuying Li Copyright (2001)
 * @version      1.0
 * @see also     Suit, CardValue
 */
public class Play2048 {
	public static void main(String[]args) {
		System.out.println("2048 controls:\n" +"\tw: move up\n"
				+"\ta: move left\n"
				+"\ts: move down\n"
				+"\td: move right\n");

		
		int Dim = Config.DIM;//create the dimension for the board;
		int [][] board= new int[Dim][Dim];//create a 4*4 array;
		//print_board(board);
		placeBlock(board);
		placeBlock(board);

		/*REMOVE THIS
		board[0][0] = 5;
		board[0][1] = 9;
		board[0][2] = 512;
		board[0][3] = 513;
		board[1][0] = 514;
		board[1][1] = 52;
		board[1][2] = 516;
		board[1][3] = 517;
		board[2][0] = 519;
		board[2][1] = 76;
		board[2][2] = 519;
		board[2][3] = 20;
		board[3][0] = 56;
		board[3][1] = 21;
		board[3][2] = 21;
		board[3][3] = 18;
		*/


		print_board(board);
		//boolean k = gameOver(board);
		while(!gameOver(board)) { // if game is not over, keep running;
			
			char input=getDirection(); //get input from the getDirection;

			if (handleInput(input,board) == true) { //if movement return true
				placeBlock(board); // generate a ramdom space to store 2
			}
			print_board(board);
		}
		System.out.println("Game over!");//if game over, print game over;
	}


	/**
	 * (This method formats and displays the board for the user.)
	 * 
	 * @param board - the 2048 board
	 * @param rowNum The number of the row for the board
	 * @param (colNum) (The number of the column for the board)
	 * @param (colNum) (The number of the column for the board)
	 * @return (return void)
	 */
	public static void print_board(int[][] board) {
		System.out.println("---------------------"); 
		// print the first dashed line only for one time;
		for (int rowNum =0; rowNum < Config.DIM; rowNum++) {
			//outer loop for the row number
			System.out.print("|");//print the first the'|' for each column;
			for (int colNum = 0; colNum < Config.DIM; colNum++) { 
				//inner loop for the column 
				int element = board[rowNum][colNum];
				String strElement=String.valueOf(element);
				//cast the integer to be string
				int lengthNum = strElement.length();
				//get the length of the number;
				for (int w = 0; w <= Config.DIM-1-lengthNum; w++) {
					// based on the length of the number, 
					// do a loop to reduce the space
					System.out.print(" "); 
				}
				if (element  == 0) { // if the element is zero
					System.out.print(" "+"|"); // just the print the space;
				}
				else{
					System.out.print(board[rowNum][colNum] + "|");
				}

			}
			System.out.println("");// to start from a new line;
			System.out.println("---------------------");
			//repeat the dashed line;
		}
	}

	/**
	 * (This method places a 2 block in a random unoccupied cell of the board.)
	 *
	 *@param board - the 2048 game board
	 * @param max The max range for the random number
	 * @param randomRow Generate the random row for the board
	 * @param randomCol generate the random column for the board
	 * @return description of the return value
	 */
	public static void placeBlock(int[][] board) {
		int max =Config.DIM; // the range for the random number;
		int randomRow = Config.rand.nextInt((max)); //get the random row
		int randomCol = Config.rand.nextInt((max)); //get the random column

		while (board[randomRow][randomCol] != 0) { 
			// if the the space is not empty
			randomRow = Config.rand.nextInt((max));
			//get the new random row and column
			randomCol = Config.rand.nextInt((max));
		}
		board[randomRow][randomCol] = 2; //assign 2 to the random space
	}

	/**
	 * This method gets user input (and checks to ensure that it's valid input
	 *
	 * @param q boolean value to keep track of the direction;
	 * @param derection string to store the input
	 * @param char the character to store the first character of the input;
	 * @param lengthDir integer to store the length of the input
	 * @return the user's input as a character
	 */
	public static char getDirection() {
		boolean q =true;
		char dir='a';// initialize the character;
		while(q){
			System.out.print("Direction:");
			String direction = Config.in.next(); // get the input
			int lengthDir = direction.length(); 
			// get the length of the input;
			if(lengthDir == 1) { // the length of the input must be 1
				if(direction.charAt(0) == (Config.UP) || 
						direction.charAt(0) == (Config.DN) || 
						direction.charAt(0) == (Config.LF) || 
						direction.charAt(0) == (Config.RT))
				{
					dir=direction.charAt(0);
					//get the first character of the input;
					q =false;// stop checking
				}
			}

		}
		return dir;
	}

	/**
	 * (handleInput is a simple centralized method for determining which move 
	 * method to call based on the user's input.)
	 *
	 * @param dir - character the user's input
	 * @param board - the 2048 game board
	 * @return false if no changes were made to the game board, true otherwise
	 */
	public static boolean handleInput(char dir, int[][] board) {
		if (dir == Config.UP) { // if the the input equals to "up";
			return moveUp(board); // call the move up method;
		}
		else if ( dir == Config.DN) { // if the the input equals to "down";
			return moveDn(board); // call the move down method;
		}
		else if (dir == Config.LF) { // if the the input equals to "left";
			return moveLf(board); // call the move left method;
		}
		else if (dir == Config.RT) { // if the the input equals to "right";
			return moveRt(board); // call the move right method;
		}

		return true; // placeholder value, so the code will compile
	}

	/**
	 * The moveUp method handles the case where the user wants to move up. 
	 * Each move consists of one move pass, 
	 * to get all cells as far up as possible, 
	 * a single merge pass to merge any adjacent cells of the same value, 
	 * and another move pass to finish.
	 *
	 * @param board - the 2048 game board
	 * @param rowNum -row number 
	 * @param colNum - column number 
	 * @param newColNum integer to store the new column
	 * @return false if no changes were made to the game board, true otherwise
	 */
	public static boolean moveUp(int[][] board) {
		boolean q =false;
		for (int rowNum = 0; rowNum  < Config.DIM - 1; rowNum ++) {
			//outer loop for the row
			for ( int colNum = 0; colNum < Config.DIM; colNum++) {
				//outer loop for the column
				if (board[rowNum][colNum] == 0) {
					//to check if the first element is 0;
					for (int newRowNum = rowNum +1; 
							newRowNum  < board[0].length; newRowNum ++) {
						// if the first element is 0, then we can do the move
						if (board[newRowNum ][colNum] != 0) {
							// if there is no empty space
							board[rowNum ][colNum] = board[newRowNum ][colNum];
							//start from the new first row 
							//and keep the column number fixed
							//and then move the next element to the up element
							q = true;// if the board is moved,then return true;
							board[newRowNum ][colNum]=0;
							//if the previous random element is moved
							//then assign 0 to that space
							break;
						}
					}
				}

			}

		}


		for(int rowNum = 0; rowNum < Config.DIM-1; rowNum++) {
			for(int colNum = 0; colNum < Config.DIM ; colNum++) {
				if(board[rowNum][colNum] !=0 && board[rowNum + 1][colNum]!= 0 
				&& board[rowNum][colNum] == board[rowNum + 1][colNum]){
					//it the next tow elements are not the same and not 
					//equal to 0;
					board[rowNum][colNum] = 
							board[rowNum][colNum] + board[rowNum+1][colNum];
					// then do the calculation;
					q=true;
					// if there is a movement, then return true;
					board[rowNum+1][colNum] = 0;//assign 0 to the empty space
				}
			}
		}
		for(int rowNum = 0; rowNum  < Config.DIM - 1; rowNum ++) {
			// when we have the new empty space, do the movement up again
			for( int colNum = 0; colNum < Config.DIM; colNum++) {
				if(board[rowNum][colNum] == 0) {
					for(int newRowNum = rowNum +1; 
							newRowNum < board[0].length; newRowNum++) {
						if(board[newRowNum][colNum] != 0) {
							board[rowNum ][colNum] = board[newRowNum][colNum];
							q=true;
							board[newRowNum][colNum] = 0;
							break;
						}
					}
				}

			}

		}

		return q; // placeholder value, so the code will compile
	}

	/**
	 * handleInput is a simple centralized method for determining 
	 * which move method to call based on the user's input.
	 *
	 * @param rowNum - row number
	 * @param colNum - column number 
	 * @param newColNum to store the new colomn number
	 * @return false if no changes were made to the game board, true otherwise
	 */
	public static boolean moveDn(int[][] board) {
		boolean q = false;
		for (int rowNum = 0; rowNum < Config.DIM; rowNum ++) {
			for ( int colNum = Config.DIM-1; colNum >= 1; colNum--) {
				// move down start from the bottom;
				if (board[colNum][rowNum ] == 0) {
					//the first bottom element is not 0;
					for (int newColNum = colNum-1;newColNum >= 0; newColNum--){
						if (board[newColNum][rowNum ] != 0) {
							board[colNum][rowNum ] = board[newColNum][rowNum ];
							q = true;
							// if there is a movement, then return true;
							board[newColNum][rowNum ] = 0;
							break;
						}
					}
				}

			}

		}
		// do the caculation from the bottom 
		for(int rowNum = Config.DIM -1; rowNum >= 1; rowNum--) {
			for(int colNum = 0; colNum < Config.DIM ; colNum++) {
				if(board[rowNum][colNum] != 0&& board[rowNum - 1][colNum]!=0
				&&board[rowNum][colNum] == board[rowNum - 1][colNum]) {
					//if the next two elements are not same and no equal to 0;
					board[rowNum][colNum] = 
					board[rowNum][colNum] + board[rowNum - 1][colNum];
					q=true;
					board[rowNum - 1][colNum] = 0;
				}
			}
		}
		for(int rowNum = 0; rowNum < Config.DIM; rowNum++ ) {
			//  after the calculation, do the same down movement  again
			for( int colNum = Config.DIM-1; colNum>=1; colNum--) {
				if(board[colNum][rowNum] == 0){
					for (int newColNum = colNum-1; 
							newColNum >= 0; newColNum--) {
						if (board[newColNum][rowNum] != 0){
							board[colNum][rowNum] = board[newColNum][rowNum];
							q=true;
							board[newColNum][rowNum] = 0;
							break;
						}
					}
				}

			}

		}
		return q; // placeholder value, so the code will compile
	}

	/**
	 * The moveLf method handles the case where the user 
	 * wants to move to the left. Each move consists of one move pass,
	 *  to get all cells as far to the left as possible, 
	 *  a single merge pass to merge any adjacent cells of the same value, 
	 *  and another move pass to finish.

	 * @param q - boolean value to keep tracking of the movement 
	 * @param rowNum - row number 
	 * @param colNum - colunmn number 
	 * @param newColNum
	 * @return false if no changes were made to the game board, true otherwise
	 */
	public static boolean moveLf(int[][] board) {
		boolean q =false;
		for (int rowNum = 0; rowNum < Config.DIM; rowNum++) {
			for ( int colNum = 0; colNum  < Config.DIM; colNum ++) {
				if (board[rowNum][colNum ] == 0) {
					// start from the first element, and check if it is 0;
					for (int newColNum = colNum +1; newColNum<board[0].length; 
							newColNum++) {
					// movement start from the first element, 
						//keep row number fixed;
						if (board[rowNum][newColNum] != 0) {
							board[rowNum][colNum ] = board[rowNum][newColNum];
							// if there is a movement, then return true;
							q = true;
							board[rowNum][newColNum] = 0;
							//assign 0 to the moved space;
							break;
						}
					}
				}

			}

		}
        //calculation after the movement
		for (int rowNum = 0; rowNum < Config.DIM; rowNum++) {
			for (int colNum = 0; colNum  < Config.DIM-1; colNum ++) {
				if (board[rowNum][colNum ] != 0 
				&& board[rowNum][colNum + 1 ]!=0 
				&&board[rowNum][colNum ] == board[rowNum][colNum + 1 ]) {
					//check condition;
					board[rowNum][colNum ] = 
					board[rowNum][colNum ] + board[rowNum][colNum  + 1];
					// do the calculation
					q=true;
					board[rowNum][colNum +1] = 0;
				}
			}
		}
		// do the movement left again after the calculation
		for (int rowNum = 0; rowNum  < Config.DIM; rowNum ++) {
			for ( int colNum = 0; colNum < Config.DIM; colNum++) {
				if (board[rowNum ][colNum] == 0) {
					for (int newColNum=colNum+1; 
							newColNum<board[0].length;newColNum++) {
						if (board[rowNum ][newColNum] != 0) {
							board[rowNum ][colNum] = board[rowNum ][newColNum];
							q = true;
							board[rowNum ][newColNum] = 0;
							break;
						}
					}
				}

			}

		}
		return q; // placeholder value, so the code will compile
	}

	/**The moveRt method handles the case where 
	 * the user wants to move to the right. 
	 * Each move consists of one move pass, 
	 * to get all cells as far to the right as possible, 
	 * a single merge pass to merge any adjacent cells of the same value, 
	 * and another move pass to finish.
	 * @param rowNum - row number 
	 * @param colNum - column number 
	 * @param newColNum - new column number to store the new column number
	 * @return false if a move may be made; true if no moves are possible
	 */
	public static boolean moveRt(int[][] board) {
		boolean q = false;
		for (int rowNum = 0; rowNum<Config.DIM;rowNum++) {
			for ( int colNum = Config.DIM-1; colNum > 0; colNum--) {
				//move start from the first right element, 
				//and then move from left to right
				if(board[rowNum][colNum] == 0) {
					// if the first right element is empty
					for(int newColNum = colNum - 1; 
							newColNum >= 0 ; newColNum--) {
						//movement start from the first right element;
						if(board[rowNum][newColNum] != 0) {
							board[rowNum][colNum] = board[rowNum][newColNum];
							//make the movement from left to right
							q = true;
							board[rowNum][newColNum] = 0;
							break;
						}
					}
				}

			}
		}
		// do the calculation after the movement
		for (int rowNum = 0;  rowNum < Config.DIM; rowNum++) {
			for (int colNum = Config.DIM-1; colNum >= 1; colNum--) {
				if (board[ rowNum][colNum] != 0 
						&& board[ rowNum][colNum-1]!=0
						&&board[ rowNum][colNum] == board[ rowNum][colNum-1]) {
					//check condition;
					board[ rowNum][colNum]=
							board[ rowNum][colNum]+board[ rowNum][colNum-1];
					q = true;
					board[ rowNum][colNum-1] = 0;
				}
			}
		}
		//do the right movement after the calculation
		for (int rowNum = 0; rowNum < Config.DIM; rowNum++) {
			for ( int colNum = Config.DIM-1; colNum >= 0; colNum--) {
				if (board[rowNum][colNum] == 0) {
					for (int newColNum = colNum-1;newColNum >= 0;newColNum--) {
						if (board[rowNum][newColNum] != 0) {
							board[rowNum][colNum] = board[rowNum][newColNum];
							q = true;
							board[rowNum][newColNum] = 0;
							break;
						}
					}
				}

			}

		}
		return q; // placeholder value, so the code will compile
	}

	/**
	 * The gameOver method checks to see if there are any moves to be made: 
	 * if any cells are unoccupied, the game is not yet over; 
	 * if all cells are occupied but a move may still be made, 
	 * the game is not yet over; otherwise, the game is over.
	 *
	 * @param rowNum - row number 
	 * @param colNum - column number 
	 * @param rowNum1 - row number
	 * @param colNum1 - column number
	 * @false if a move may be made; true if no moves are possible
	 */
	public static boolean gameOver(int[][] board) {
		//check all the element one by one to find 2048
		for(int rowNum =0; rowNum<=Config.DIM-1; rowNum++ ) {
			for(int colNum=0; colNum <= Config.DIM-1; colNum++) {
				if(board[rowNum][colNum]==2048){
					//if there is 2048, game over
					return true;
				}
			}
		}
		// check all the element one by one to find 0 
		for(int rowNum = 0; rowNum <= Config.DIM-1; rowNum ++ ) {
			for(int colNum = 0; colNum <= Config.DIM-1; colNum++) {
				if (board[rowNum ][colNum] == 0 ){
					//if there is 0; then game is not over
					return false;
				}
			}
		}
		// check each element with the right element and downside element 
		for(int rowNum=0;rowNum<=Config.DIM-2;rowNum++) {
			for(int colNum = 0;colNum <= Config.DIM-2;colNum++) {
				//if two neighbor elements are the same, 
				//then we can still do the calculation
				if (board[rowNum+1][colNum]==board[rowNum][colNum] 
						|| board[rowNum][colNum]==board[rowNum][colNum+1]) {
					return false;
					//game is not over
				}
            //fix the 4th row of the element 
				//because this row is ignore by last block of code
				for(int colNum1=0; colNum1<=Config.DIM-2;colNum1++) {
					int rowNum1 = Config.DIM-1;
					if (board[rowNum1][colNum1] == board[rowNum1][colNum1+1]) {
						//if the two neighbor elements are the same
						return false;
						//game is not over
					}
				}
				// check the 4th column of elements 
				for(int rowNum1 =  0; rowNum1 <= Config.DIM-2; rowNum1++) {
					int colNum1 = Config.DIM-1;
					if (board[rowNum1][colNum1] == board[rowNum1+1][colNum1]){
						//if next up and down element 
						//in the 4th column are the same
						return false;
						//game is not over 
					}
				}
				// check for open squares
				// check for possible horizontal merges
				// check for possible vertical merges
				// placeholder value, so the code will compile

				
			} 

		}
		return true;
	} 
}



