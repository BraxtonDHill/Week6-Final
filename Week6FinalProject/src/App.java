import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	List<String> names = List.of("Braxton", "Devin");

	Random random = new Random();

	public static void main(String[] args) {
		new App().playGame();
	}

	private void playGame() {
		List<String> playerNames = new LinkedList<>(names);
		Player player1 = findPlayer(playerNames);
		Player player2 = findPlayer(playerNames);
		Deck deck = new Deck();

		shuffleDeck(deck);
		dealTheCards(player1, player2, deck);
		declareWinner(player1, player2);
//		System.out.println(player1.hand);
//		System.out.println(player2.hand);
	}

	private void declareWinner(Player player1, Player player2) {
		for (int i = 0; i < 26; i++) {
			Card p1card = player1.flip();  //Question 2c
			Card p2card = player2.flip();
			System.out.println(player1 + " played " + p1card + " against " + player2 + "'s " + p2card);
			if (p1card.getValue() > p2card.getValue()) {  //Question d
				player1.incrementScore();
				System.out.println(player1 + "'s " + p1card.getValue() + " beats " + player2 + "'s " + p2card.getValue());
			} else if (p2card.getValue() > p1card.getValue()) {
				player2.incrementScore();
				System.out.println(player2 + "'s " + p2card.getValue() + " beats " + player1 + "'s " + p1card.getValue());
			}
				System.out.println("SCORE!" + player1 + ": " + player1.getScore() + "     " + player2 + ": " + player2.getScore());
		}
		if (player1.getScore() > player2.getScore()) { //Question e
			System.out.println(player1 + " wins! With a score of: " + player1.getScore());
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println(player2 + " wins! With a score of:" + player2.getScore());
		} else {
			System.out.println("Draw");
		}
	}

	private void dealTheCards(Player player1, Player player2, Deck deck) {
		for (int i = 0; i < 26; i++) {
			player1.draw(deck);
			player2.draw(deck); //Question 2b
		}
	}

	private void shuffleDeck(Deck deck) {
		deck.shuffle();
	}

	private Player findPlayer(List<String> playerNames) {
		int pos = random.nextInt(playerNames.size());
		String name = playerNames.remove(pos);

		return new Player(name);
	}
}
