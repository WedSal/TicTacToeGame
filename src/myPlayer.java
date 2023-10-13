public class myPlayer {

    private char symbol; //declares variables for symbol and name
    private String name;

    public myPlayer(char symbol) { //constructor for myPlayer, receives symbol and name
        this.symbol = symbol;
        this.name = " ";
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { //set the players name to what has been sent as a parameter
        this.name = name;
    }

    public boolean makeMove(myBoard board, int row, int col) { //the method of performing a move
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, symbol);
            return true;
        }
        return false;

    }

}
