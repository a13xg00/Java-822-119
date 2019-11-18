package card_game;

import java.util.Scanner;

public class Player {

    public String name;
    public int score = 0;
    public int[] cards = new int[26];

    public Player() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = input.nextLine();
        for (int i = 0; i < cards.length; i++) {
            int random = (int) (Math.random() * 15);
            cards[i] = random;
        }
        this.name = name;
    }

}