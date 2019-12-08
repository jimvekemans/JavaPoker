package model.pokerBeans;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public String toString() {
        return rank.getRankString() + " of " + suit.toString();
    }

    @Override
    public int compareTo(Card otherCard) {
        int thisCardValue = rank.getRankValue();
        int otherCardValue = otherCard.getRank().getRankValue();
        CardSuit thisCardSuit = suit;
        CardSuit otherCardSuit = otherCard.getSuit();

        if (thisCardValue > otherCardValue) {
            return -1;
        } else if (thisCardValue < otherCardValue) {
            return 1;
        } else {
            return (thisCardSuit.equals(otherCardSuit)) ? 0 : 1;
        }
    }
}
