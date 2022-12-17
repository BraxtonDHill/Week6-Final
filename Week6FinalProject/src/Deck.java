import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	List<String> values = List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
	List<String> names = List.of("Clubs", "Hearts", "Spades", "Diamonds");

	List<Card> cards = new LinkedList<Card>();

	public Deck() {
		createDeck();
	}

	private void createDeck() {
		for (int i = 0; i < values.size(); i++) {
			int cardValue = i + 2;
			String cardName = values.get(i);
			for (String name : names) {
				cards.add(new Card(cardValue, cardName, name));
			}
		}
	}
	@Override
	public String toString() {    //this is my describe, learned from instructor video
		StringBuilder builder = new StringBuilder();
		
		builder.append("Deck:\n");
		
		for (Card card : cards) {
			builder.append(" ").append(card).append("\n");
		}
		return builder.toString();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		return cards.remove(0);
	}
}
