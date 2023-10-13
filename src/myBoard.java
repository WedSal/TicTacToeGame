public class myBoard {
    private char[][] board; // declares a 2D array to display the game board as 3x3

    public myBoard() { //constructor for the myboard class, this to create and start the game board
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // space = empty box

            }
        }
    }

    public void printBoard() { // the method of printing the board
        System.out.println("Game Board: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]); // prints the value in each cell
                if (j < 2) {
                    System.out.print("  | "); //seperate colons with | if less than two
                }
            }
            System.out.println();

            if (i < 2) {
                System.out.println("---------------"); //prints line
            }

        }
    }

    public boolean checkWin(char player) {  // the method of checking if player  has win
        for (int i = 0; i < 3; i++) { //checks rows, cols & diagonals to see if there are 3 in a row
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public boolean isBoardFull() { // the method to check if the board is full.
        for (int i = 0; i < 3; i++) { // loop to see if there are any empty box left
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') { //if an empty box is found return false
                    return false;
                }
            }
        }
        return true; // return true if no empty box is found.
    }

    public boolean isValidMove(int row, int col) { //checks if the move is valid.
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '; //checks if the spceified rows or cols are valid or if the box is empty
    }

    public boolean makeMove(int row, int col, char symbol) { //the method of performing a move
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
            return true; //if the move is valid
        }
        return false;
    }


    public void resetBoard() { //the method to restore the board to empty boxes
        //loop through each box on the board and reset it to an empty box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
}


