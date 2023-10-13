import java.util.Scanner;

public class TicTacToeGame { //  defines the main class and metod
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {   // outer loop to restart the game

            myBoard board = new myBoard();  // input of the myboard class, stored in the variable board
            myPlayer playerX = new myPlayer('X');
            myPlayer playerO = new myPlayer('O');

            // Asking for players names
            System.out.print("Enter the name for player X: ");
            String playerNameX = scanner.nextLine();
            playerX.setName(playerNameX);  //calling setName method from myPlayer class

            System.out.print("Enter the name for player O: ");
            String playerNameO = scanner.nextLine();
            playerO.setName(playerNameO);

            char currentPlayerSymbol = 'X';   //Game starts with player X
            boolean gameOver = false;

            int row, col;     //   stores the players moves

            while (!gameOver) { // inner loop to play single game, loop starts here, runs as long as gameover is false
                board.printBoard(); // printboard method is called to draw the game board and display to the user
                myPlayer currentPlayer = (currentPlayerSymbol == 'X') ? playerX : playerO;
                boolean validMove = false;  // checks whether the players move is valid or not

                while (!validMove) {   // to request valid moves from the player
                    System.out.println("Player " + currentPlayerSymbol + " (" + currentPlayer.getName() + ") , write row (0-2) and column (0-2): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();


                    if (board.isValidMove(row, col)) {
                        validMove = currentPlayer.makeMove(board, row, col);
                    } else {
                        System.out.println("Invalid move. Please try again!");
                    }
                }


                if (board.checkWin(currentPlayerSymbol)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayerSymbol + " wins! ");
                    gameOver = true;   //  ending the game on win
                } else if (board.isBoardFull()) {
                    board.printBoard();
                    System.out.println("The board is full! it is a draw. ");
                    gameOver = true; // terminates the loop in the event of a tie game.
                } else {
                    currentPlayerSymbol = (currentPlayerSymbol == 'X') ? 'O' : 'X'; // if the symbol is currently X, the value will change to O & vice versa


                }

            }
            // Asking player if they want to play more?
            System.out.println("Do you want to play again? (yes/no) : ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;     // Finishing outer loop if no
            }
        }
        scanner.close();    // scanner closing the object .

    }
}

//TicTacToeGame

