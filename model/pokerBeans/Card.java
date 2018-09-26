package pokerBeans;

import java.util.Comparator;

public class Card implements Comparator<Card>, Comparable<Card> {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compare(Card thisCard, Card otherCard) {
        //if higher --> 1, lower --> -1, equal --> 0
        int thisCardValue = thisCard.getRank().getRankValue();
        int otherCardValue = otherCard.getRank().getRankValue();
        CardSuit thisCardSuit = thisCard.getSuit();
        CardSuit otherCardSuit = otherCard.getSuit();

        if (thisCardValue > otherCardValue) {
            return -1;
        } else if (thisCardValue < otherCardValue) {
            return 1;
        } else {
            return (thisCardSuit.equals(otherCardSuit)) ? 0 : 1;
        }
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
