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
        // for loop fills target array with 3 random numbers
        for (int i = 0; i < 3; i++) {
            target[i] = (int)(Math.random() * 10);
            // target [0] is the first number target [1] is the second number and target [3] is the third number
            System.out.println(target[0] + " " + target[1] + " " + target[2]);
        }
    }    
    // builds an arrylist of strings 
    public String getHint(int userinput1, int userinput2, int userinput3) {
        StringBuilder output = new StringBuilder();
        // every time getHint runs guessCount increases
        guessCount++;
        // guesses are stored in an array
        int[] guess = { userinput1, userinput2, userinput3 };
        // hints fermi pico and nano are stored as strings in an array list
        ArrayList<String> hints = new ArrayList<>();
        // array storing true or false false by default
        boolean[] guessUsed = new boolean[3];

        for (int i = 0; i < 3; i++) {
            // if the guess is equal to the generated number add fermi to the array list
            if (guess[i] == target[i]) {
                hints.add("Fermi");
                guessUsed[i] = true;
            }
        } 
        for (int i = 0; i < 3; i++) {
            // if guessUsed is false run the code if true skip it only check guesses not matched as fermi
            if (!guessUsed[i]) {
                // checks each target with nested for loop target[0] target[1] target[2]
                for (int p = 0; p < 3; p++) {
                    // if guessUsed is false and guess = target add pico to the arraylist
                    if (!guessUsed[p] && guess[i] == target[p]) {
                        hints.add("Pico");
                        guessUsed[i] = true;
                        break;
                    }
                }
            }
        }
        // if the hints arraylist is less than 1 add 3 nanos to the list
        if (hints.size() < 1) {
            hints.add("Nano");
            hints.add("Nano");
            hints.add("Nano");
        } else if (hints.size() < 2) {
            hints.add("Nano");
            hints.add("Nano"); 
        } else if (hints.size() < 3) 
           hints.add("Nano");
        System.out.println(hints);
        // if all of users guesses are the same as target game is over and text feilds and ok button stop working
        if (userinput1 == target[0] && userinput2 == target[1] && userinput3 == target[2]) {
            gameOver = true;
            // format for text area 
            output.append(String.format("%d %d %d : Fermi Fermi Fermi\nCongratulations! Guesses: %d",userinput1, userinput2, userinput3, guessCount));
            return output.toString();
        }

        output.append(String.format("%d %d %d : %s %s %s",userinput1, userinput2, userinput3, hints.get(0), hints.get(1), hints.get(2)));
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
