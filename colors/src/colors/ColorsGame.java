package colors;

import java.util.Arrays;
import java.util.Scanner;

public class ColorsGame {

    public static void main(String[] args) {

        String[] colors = {"b", "y", "r", "g", "o"};
        String[] randomColors = new String[3];
        String[] playerColors = new String[3];
        String[] gameScore = new String[3];
        String[] winArray = {"X","X","X"};
        int triesCount = 0;
        int i = 0;

        while ( i < 3 ){
            boolean addColor = true;
            int random = (int) (Math.random() * 5);
            for (int j = 0; j < randomColors.length; j++) {
                if (randomColors[j] == (colors[random])) {
                    addColor = false;
                }
            }
            if(addColor){
                randomColors[i] = colors[random];
                i++;
            }
        }

        while (!Arrays.equals(gameScore, winArray)){
            for (int j = 0; j < 3; j++) {
                Scanner input = new Scanner(System.in);
                System.out.printf("Please choose one of 3 colors from : %s  : ", Arrays.toString(colors));
                playerColors[j] = input.nextLine();
                if (playerColors[j].equals("x")){
                    System.out.printf("\nGAME OVER\nYou Tried %d times", triesCount);
                    System.exit(1);
                }
            }
            for (int j = 0; j < 3; j++) {
                boolean colorExistInRandomArray = false;
                for (String color: randomColors) {
                    if (playerColors[j].equals(color)){
                        colorExistInRandomArray = true;
                    }
                }
                if (colorExistInRandomArray) {
                    gameScore[j] = (playerColors[j].equals(randomColors[j])) ? "X" : "O";
                } else gameScore[j] = "_";
            }
            System.out.printf("Your Score: %s\n", Arrays.toString(gameScore));
            triesCount ++;
        }
        System.out.printf("YOU WIN!!!You Tried %d times\n", triesCount);
    }
}

