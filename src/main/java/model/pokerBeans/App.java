package model.pokerBeans;

import java.util.*;

public class App {

    public static void main(String[] args) {
        List<Card> playerList;
        List<Card> tableList;
        boolean currentCondition;

        do {
            Stack<Card> deckOfCards = new Stack<>();
            for (CardSuit suit : CardSuit.values()) {
                for (CardRank rank : CardRank.values()) {
                    deckOfCards.push(new Card(suit, rank));
                }
            }
            Collections.shuffle(deckOfCards);
            playerList = new LinkedList<>(
                    Arrays.asList(
                            deckOfCards.pop(),
                            deckOfCards.pop()
                    )
            );
            tableList = new LinkedList<>(
                    Arrays.asList(
                            deckOfCards.pop(),
                            deckOfCards.pop(),
                            deckOfCards.pop(),
                            deckOfCards.pop(),
                            deckOfCards.pop()
                    )
            );

            //currentCondition = (PokerCombinations.getHighCard(playerList, tableList).compareTo(CardRank.TEN)) >= 1;
            //currentCondition = (PokerCombinations.hasXOfAKind(4, playerList, tableList));
            //currentCondition = PokerCombinations.hasStraight(playerList, tableList);
            //currentCondition = (PokerCombinations.hasFlush(playerList, tableList));
            //currentCondition = PokerCombinations.hasMultiplePairs(playerList, tableList, 3);
            currentCondition = PokerCombinations.hasStraightFlush(playerList, tableList);
        } while (!currentCondition);
        playerList.forEach(System.out::println);
        tableList.forEach(System.out::println);
    }
}
