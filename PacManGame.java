import java.util.*;

public class PacManGame {
    public static final int BOARD_SIZE = 8; // Set the size of the board
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public static void clearScreen() {
        // Placeholder for screen-clearing logic
    }

    public static void main(String[] args) {
        // Initialize actors
        PacMan pacMan = new PacMan(BOARD_SIZE / 2, BOARD_SIZE / 2); // Start in the middle
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(pacMan);
        actors.add(new Ghost(0, 0)); // First Ghost
        actors.add(new Ghost(BOARD_SIZE - 1, BOARD_SIZE - 1)); // Second Ghost

        while (true) {
            // Clear the board
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = '.'; // Empty space
                }
            }

            // Place actors on the board
            for (Actor actor : actors) {
                board[actor.getY()][actor.getX()] = actor.getSymbol();
            }

            // Print the board
            clearScreen();
            System.out.println("\nGame Board:");
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Check if Pac-Man collides with any other actor
            for (Actor actor : actors) {
                if (actor != pacMan && pacMan.getX() == actor.getX() && pacMan.getY() == actor.getY()) {
                    System.out.println("Game Over! Pac-Man collided with " + actor.getSymbol());
                    return;
                }
            }

            // Move all actors
            for (Actor actor : actors) {
                actor.move();
            }
        }
    }
}
