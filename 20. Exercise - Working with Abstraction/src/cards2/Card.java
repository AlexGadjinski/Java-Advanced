package cards2;

public class Card {
    private final Suit suit;
    private final Rank rank;
    private final int power;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.power = suit.getPower() + rank.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank, suit, power);
    }
}
