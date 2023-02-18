package SnakeAndLadder;

public abstract class Jump {
    int start;
    int end;
    public Jump(int s, int e) {
        this.start = s;
        this.end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
