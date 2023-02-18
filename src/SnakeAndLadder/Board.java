package SnakeAndLadder;

import java.util.ArrayList;

public class Board {
    int boardSize;
    ArrayList<Jump> jumps;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        jumps = new ArrayList<>();
    }

    public int getBoardSize() {
        return boardSize;
    }

    //    void printBoard()
    public void addJumpToList(Jump jump) {
        jumps.add(jump);
    }
    Jump hasJumpAtPosition(int position) {
        for(Jump jump: jumps) {
            if(jump.getStart() == position) return jump;
        }
        return null;
    }

}
