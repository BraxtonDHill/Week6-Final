import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	public int score;
	public List<Card> hand = new LinkedList<Card>();

	
	public Player (String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return name;
	}
	public List<Card> getHand() {
		return hand;
	}
	public Card flip() {
		return hand.remove(0);
	}
	public int incrementScore() {
		return score++;
	}
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	@Override
	public String toString() {  //describe method
		return name;
	}

	public int getScore() {
		return score;
	}

}

