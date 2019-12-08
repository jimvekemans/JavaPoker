package model.pokerBeans;

import java.util.LinkedList;
import java.util.List;

// Player is an observer of the RoundOfPoker class
public class Player implements Observer{
    private List<Card> cardsInHand = new LinkedList<>();
    private int amountOfPokerChips = 50000;

    Player(Card first, Card second) {
        cardsInHand.add(first);
        cardsInHand.add(second);
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    @Override
    public boolean foldRound() {
        return false;
    }

    @Override
    public int wageChips() {
        return 0;
    }
}