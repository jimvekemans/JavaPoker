package model.pokerBeans;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RoundOfPoker {
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

}

class Player {
    LinkedList<Card> cardsInHand;

    Player(Card first, Card second) {
        cardsInHand.add(first);
        cardsInHand.add(second);
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }
}
