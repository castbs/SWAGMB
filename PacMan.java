import java.util.Scanner;

class PacMan implements Actor {
    private int x, y; // Position of Pac-Man
    private char symbol = 'P'; // Symbol for Pac-Man

    public PacMan(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Move Pac-Man (W/A/S/D): ");
        char input = scanner.nextLine().toUpperCase().charAt(0);

        switch (input) {
            case 'W': if (y > 0) y--; break; // Up
            case 'A': if (x > 0) x--; break; // Left
            case 'S': if (y < PacManGame.BOARD_SIZE - 1) y++; break; // Down
            case 'D': if (x < PacManGame.BOARD_SIZE - 1) x++; break; // Right
            default: System.out.println("Invalid move!");
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
