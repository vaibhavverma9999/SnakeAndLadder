package SnakeAndLadder;

import java.util.Queue;

public class Game {
    Queue<Player> playerQueue;
    Board board;
    Dice dice;

    public Game(Queue<Player> playerQueue, Board board, Dice dice) {
        this.playerQueue = playerQueue;
        this.board = board;
        this.dice = dice;
    }

    public void addPlayerToQueue(Player player) {
        playerQueue.add(player);
    }
    public int getPlayerQueueSize() {
        return playerQueue.size();
    }
    boolean checkWin(int position) {
        return position == board.getBoardSize();
    }
    boolean checkInvalidMove(int newPosition) {
        return newPosition> board.getBoardSize();
    }
    public void nextMove() {
        Player player = playerQueue.poll();
        System.out.println(player.getName()+" playing at "+player.getPosition());
        int steps = dice.rollDice();
        int newPosition = player.getPosition()+steps;
        if(checkWin(newPosition)) {
            System.out.println("Player "+player.getName()+" wins!!");
            return;
        }
        Jump jumpAtNewPosition = board.hasJumpAtPosition(newPosition);
        if(jumpAtNewPosition != null) {
            if(jumpAtNewPosition instanceof Ladder) {
                System.out.println(player.getName() + " climbs ladder from " + jumpAtNewPosition.getStart() + " to "
                        + jumpAtNewPosition.getEnd());
            }
            else {
                System.out.println(player.getName() + " bitten by snake from " + jumpAtNewPosition.getStart() + " to "
                        + jumpAtNewPosition.getEnd());
            }
            player.setPosition(jumpAtNewPosition.getEnd());
        }
        else if(!checkInvalidMove(newPosition)) {
            player.setPosition(newPosition);
        }
        addPlayerToQueue(player);
    }
}
