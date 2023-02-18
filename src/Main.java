import SnakeAndLadder.*;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Defining number of dices
        int numberOfDices = 2;

        // Initialising player queue
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Player player3 = new Player("Dave");
        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.offer(player1);
        playerQueue.offer(player2);
        playerQueue.offer(player3);

        // Defining board with jumps
        Board board = new Board(100);
        board.addJumpToList(new Snake(95, 50));
        board.addJumpToList(new Snake(70, 20));
        board.addJumpToList(new Snake(65, 9));
        board.addJumpToList(new Snake(40, 19));
        board.addJumpToList(new Snake(80, 55));
        board.addJumpToList(new Snake(28, 7));
        board.addJumpToList(new Ladder(8, 47));
        board.addJumpToList(new Ladder(11, 35));
        board.addJumpToList(new Ladder(25, 90));
        board.addJumpToList(new Ladder(44, 67));
        board.addJumpToList(new Ladder(54, 85));

        // Defining Game
        Game game = new Game(playerQueue, board, new Dice(numberOfDices));

        // Playing the game
        while(game.getPlayerQueueSize()>1) {
            game.nextMove();
        }
    }
}