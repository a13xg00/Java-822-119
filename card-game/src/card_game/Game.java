package card_game;

public class Game {

    public static void main(String[] args) {

        Player playerOne = new Player();
        Player playerTwo = new Player();

        int scoreWeight = 1;

        for (int i = 0; i < 26; i++) {
            playerOne.score = (playerOne.cards[i] > playerTwo.cards[i]) ? playerOne.score += scoreWeight : playerOne.score;
            playerTwo.score = (playerOne.cards[i] < playerTwo.cards[i]) ? playerTwo.score += scoreWeight : playerTwo.score;
            scoreWeight = (playerOne.cards[i] == playerTwo.cards[i]) ? 2 : 1;
        }

        if (playerOne.score != playerTwo.score) {
            String winnerName = (playerOne.score > playerTwo.score) ? playerOne.name : playerTwo.name;
            System.out.printf("%s WIN with score: %d\n", winnerName, Math.max(playerOne.score, playerTwo.score));
        } else {
            System.out.printf("GAME OVER\n");
        }
    }
}