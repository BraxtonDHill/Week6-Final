
public class Card {
	private String name;
	private int value;
	private String suit;
	
	public Card(int _cardValue, String _cardName, String _suit) {
		this.value = _cardValue;
		this.name = _cardName;
		this.suit = _suit;
	}

	@Override
	public String toString() {
		return name + " of " + suit; //describe method
	}

	public int getValue() {
		return this.value;
	}
}

