package strings;

public class Game {

    public static String gameWinner(String colors) {
        // Write your code here
        boolean isGameOver = false;
        String whoseTurn = "wendy";
        String whoWon = "";
        String currentWinner = "";
        int wendyPos = 0;
        int bobPos = 0;
        while (!isGameOver) {
            if (whoseTurn.equalsIgnoreCase("wendy")) {
                boolean canMove = false;
                for (int i = wendyPos; i < colors.length(); i++) {
                    char c = colors.charAt(i);
                    if (c == 'w' && i != 0 && i < colors.length() - 1) {
                        if (c == colors.charAt(i - 1) && c == colors.charAt(i + 1)) {
                            colors = colors.substring(0, i) + colors.substring(i + 1);
                            canMove = true;
                            wendyPos = i - 1;
                            break;
                        }
                    }
                }
                if (!canMove) {
                    whoWon = "bob";
                    isGameOver = true;
                } else {
                    whoseTurn = "bob";
                    currentWinner = "wendy";
                }
            } else {
                boolean canMove = false;
                for (int i = bobPos; i < colors.length(); i++) {
                    char c = colors.charAt(i);
                    if (c == 'b' && i != 0 && i < colors.length() - 1) {
                        if (c == colors.charAt(i - 1) && c == colors.charAt(i + 1)) {
                            colors = colors.substring(0, i) + colors.substring(i + 1);
                            canMove = true;
                            bobPos = i - 1;
                            break;
                        }
                    }
                }
                if (!canMove) {
                    whoWon = "wendy";
                    isGameOver = true;
                } else {
                    whoseTurn = "wendy";
                    currentWinner = "bob";
                }
            }
        }
        if (whoWon.equalsIgnoreCase("")) return currentWinner;
        return whoWon;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        String colors = "wwwbbbwwwbbbwwwbbbwwwbbbwwwbbb";
        System.out.println(gameWinner(colors));
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
