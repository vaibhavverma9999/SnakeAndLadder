package SnakeAndLadder;

public class Dice {
    int numberOfDice;
    public Dice(int num) {
        this.numberOfDice = num;
    }
    public int rollDice() {
        int range = 6 * numberOfDice;
        return (int)(Math.random() * range) + 1;
    }
}
