package model.pokerBeans;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RoundOfPoker implements Subject{
    private List<Player> players;
    private Stack<Card> deckOfCards;

    public RoundOfPoker() {
        deckOfCards = new Stack<>();
        createDeck();
    }

    private void createDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                deckOfCards.push(new Card(suit, rank));
            }
        }
        Collections.shuffle(deckOfCards);
    }

    public Stack<Card> getDeck() {
        return deckOfCards;
    }

    public Player addPlayerToRound(Player player) {
        return null;
    }

    public boolean removePlayerFromRound(Player player) {
        return false;
    }

    @Override
    public void notifyStartOfTurn() {

    }

    @Override
    public void notifyEndOfRound() {

    }
}
