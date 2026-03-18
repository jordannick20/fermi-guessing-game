import java.util.ArrayList;

public class HintManager {

    private final int[] target = new int[3];
    private int guessCount = 0;
    public HintManager() {
        generateTarget();
    }

    // generate 3 UNIQUE random digits (0–9)
    private void generateTarget() {

        for (int i = 0; i < 3; i++) {
            target[i] = (int)(Math.random() * 10);
            System.out.println(target[0] + " " + target[1] + " " + target[2]);
        }
    }    
}