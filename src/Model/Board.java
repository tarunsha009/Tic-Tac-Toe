package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] cardBoard;
//    private List<Player> playerList;

    public Board(){
        this.cardBoard = new char[3][3];
        initBoard(this.cardBoard);
//        playerList = new ArrayList<>();
    }

    public void initBoard(char[][] cardBoard){
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                cardBoard[i][j] = '-';
            }
        }
    }

    public char[][] getCardBoard() {
        return cardBoard;
    }

//    public List<Player> getPlayerList() {
//        return playerList;
//    }
//
//    public void setPlayerList(List<Player> playerList) {
//        this.playerList = playerList;
//    }
}
