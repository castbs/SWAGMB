class Ghost implements Actor {
    private int x, y; // Position of the Ghost
    private char symbol = 'G'; // Symbol for Ghost

    public Ghost(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move() {
        int direction = (int) (Math.random() * 4); // Random number 0-3
        switch (direction) {
            case 0: if (y > 0) y--; break; // Up
            case 1: if (x > 0) x--; break; // Left
            case 2: if (y < PacManGame.BOARD_SIZE - 1) y++; break; // Down
            case 3: if (x < PacManGame.BOARD_SIZE - 1) x++; break; // Right
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }
}
