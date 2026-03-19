import java.util.ArrayList;

public class HintManager {

    private final int[] target = new int[3];
    private int guessCount = 0;
    private boolean gameOver = false;
    public HintManager() {
        generateTarget();
    }

    // generate 3 random digits 
    private void generateTarget() {

        for (int i = 0; i < 3; i++) {
            target[i] = (int)(Math.random() * 10);
            System.out.println(target[0] + " " + target[1] + " " + target[2]);
        }
    }    

    public String getHint(int num1, int num2, int num3) {
        StringBuilder output = new StringBuilder();
        guessCount++;

        int[] guess = { num1, num2, num3 };

        ArrayList<String> hints = new ArrayList<>();

        boolean[] targetUsed = new boolean[3];
        boolean[] guessUsed = new boolean[3];

        for (int i = 0; i < 3; i++) {
            if (guess[i] == target[i]) {
                hints.add("Fermi");
                targetUsed[i] = true;
                guessUsed[i] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!guessUsed[i]) {
                for (int p = 0; p < 3; p++) {
                    if (!targetUsed[p] && guess[i] == target[p]) {
                        hints.add("Pico");
                        targetUsed[p] = true;
                        guessUsed[i] = true;
                        break;
                    }
                }
            }
        }

        while (hints.size() < 3) {
            hints.add("Nano");
        }
        if (num1 == target[0] && num2 == target[1] && num3 == target[2]) {
            gameOver = true;
            // format for text area 
            output.append(String.format("%d %d %d : Fermi Fermi Fermi\nCongratulations! Guesses: %d",num1, num2, num3, guessCount));
            return output.toString();
        }

        output.append(String.format("%d %d %d : %s %s %s",num1, num2, num3, hints.get(0), hints.get(1), hints.get(2)));
        return output.toString();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void reset() {
        guessCount = 0;
        gameOver = false;
        generateTarget();
    }
}
