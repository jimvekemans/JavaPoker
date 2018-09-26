package pokerBeans;

import java.util.Collection;

public class MethodReturner{
    boolean condition;
    Collection<Card> cards;

    MethodReturner(boolean condition, Collection<Card> cards){
        this.condition = condition;
        this.cards = cards;}

    boolean isTrue(){ return condition; }

    Collection<Card> getCards(){ return cards; }
}
