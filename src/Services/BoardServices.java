package Services;

import Model.Board;
import Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardServices {

    private Board board;

    public BoardServices(){
        board = new Board();
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        char[][] cardBoard = board.getCardBoard();
        System.out.println("****************************************");
        System.out.println("****** Welcome to Tic Tac Toe Game *****");
        System.out.println("****************************************");
        System.out.println("Player 1, what is your name ?");
        String player1 =sc.nextLine();
        System.out.println("Player 2, what is your name ?");
        String player2 =sc.nextLine();

//        List<Player> playerList = new ArrayList<>();
//        playerList.add(new Player(p1));
//        playerList.add(new Player(p2));
//        board.setPlayerList(playerList);

        boolean playerTurn = true;
        boolean gameCompeleted = false;

        while(!gameCompeleted){
            drawBoard(cardBoard);

            char c = '-';
            if(playerTurn){
                System.out.println(player1 + "'s turn (x):");
                c = 'X';
            }
            else {
                System.out.println(player2 + "'s turn (o):");
                c = 'o';
            }

            int row = 0;
            int col = 0;
            while(true){
                System.out.println("Enter a row number (0,1 or 2): ");
                row = sc.nextInt();
                System.out.println("Enter a col number (0,1 or 2): ");
                col = sc.nextInt();

                if( row < 0 || col < 0 || row >2 || col >2){
                    System.out.println("Not the correct values, please try again.");
                }
                else if(cardBoard[row][col] != '-'){
                    System.out.println("This position is already filled, please try again.");
                }
                else{
                    break;
                }
            }

            cardBoard[row][col] = c;

            if(playerWon(cardBoard) == 'X'){
                System.out.println(player1 + " won!");
                gameCompeleted = !gameCompeleted;
            }
            else if(playerWon(cardBoard) == 'o'){
                System.out.println(player2 + " won!");
                gameCompeleted = !gameCompeleted;
            }
            else {
                if(boardFull(cardBoard)){
                    System.out.println("Its a tie!");
                    gameCompeleted = !gameCompeleted;
                }
                else {
                    playerTurn = !playerTurn;
                }
            }

            drawBoard(cardBoard);
        }

    }

    private boolean boardFull(char[][] cardBoard) {
        for(int i =0;i<3;i++){
            for(int j =0;i<3;j++){
                if(cardBoard[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    private char playerWon(char[][] cardBoard) {
        // row
        for(int i = 0;i<3;i++){
            if(cardBoard[i][0] != '-' && cardBoard[i][0] == cardBoard[i][1] && cardBoard[i][1] == cardBoard[i][2]){
                return cardBoard[i][0];
            }
        }

        // col
        for(int j = 0;j<3;j++){
            if(cardBoard[0][j] != '-' && cardBoard[0][j] == cardBoard[1][j] && cardBoard[1][j] == cardBoard[2][j]){
                return cardBoard[0][j];
            }
        }

        //diagonal
        if(cardBoard[0][0] !='-' && cardBoard[0][0] == cardBoard[1][1] && cardBoard[1][1] == cardBoard[2][2]){
            return cardBoard[0][0];
        }

        if(cardBoard[0][2] !='-' && cardBoard[0][2] == cardBoard[1][1] && cardBoard[1][1] == cardBoard[2][0]){
            return cardBoard[0][0];
        }

        return ' ';
    }

    public void drawBoard(char[][] board){
        System.out.println("Board:");
        for(int i = 0;i<3;i++){
            for(int j = 0; j<3;j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
