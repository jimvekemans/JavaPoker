package pokerBeans;

import java.util.Collection;
import java.util.LinkedList;

public class PokerCombinations {

    public static <T extends Collection<Card>> CardRank getHighCard(T playerHand, T table) {
        LinkedList<Card> cardLinkedList = new LinkedList<>(playerHand);
        cardLinkedList.addAll(table);
        cardLinkedList.sort(Card::compareTo);
        CardRank highestRank = CardRank.TWO;

        for (int i = 0; i < cardLinkedList.size(); i++) {
            CardRank currentRank = cardLinkedList.get(i).getRank();
            if (currentRank.getRankValue() > highestRank.getRankValue()) {
                highestRank = currentRank;
            }
        }

        return highestRank;
    }

    public static <T extends Collection<Card>> boolean HasXOfAKind(int amount, T playerHand, T table) {
        LinkedList<Card> cardLinkedList = new LinkedList<>(playerHand);
        cardLinkedList.addAll(table);
        cardLinkedList.sort(Card::compareTo);

        for (int i = 0; i < cardLinkedList.size() - amount; i++) {
            if (cardLinkedList.get(i).getRank().getRankValue() == cardLinkedList.get(i + amount - 1).getRank().getRankValue()) {
                return true;
            }
        }

        return false;
    }

    public static <T extends Collection<Card>> boolean HasStraight(T playerHand, T table) {
        LinkedList<Card> cardLinkedList = new LinkedList<>(playerHand);
        cardLinkedList.addAll(table);
        cardLinkedList.sort(Card::compareTo);

        for (int i = 0; i < cardLinkedList.size() - 5; i++) {
            if (cardLinkedList.get(i).getRank().getRankValue() - 4 == cardLinkedList.get(i + 4).getRank().getRankValue())
                return true;
        }

        return false;
    }

    public static <T extends Collection<Card>> boolean HasFlush(T playerHand, T table) {
        LinkedList<Card> cardLinkedList = new LinkedList<>(playerHand);
        cardLinkedList.addAll(table);
        cardLinkedList.sort(Card::compareTo);
        int[] suitCounter = {0, 0, 0, 0};

        for (Card c : cardLinkedList) {
            switch (c.getSuit()) {
                case CLUBS:
                    suitCounter[0]++;
                    break;
                case DIAMONDS:
                    suitCounter[1]++;
                    break;
                case HEARTS:
                    suitCounter[2]++;
                    break;
                case SPADES:
                    suitCounter[3]++;
                    break;
            }
        }

        return suitCounter[0] > 4 || suitCounter[1] > 4 || suitCounter[2] > 4 || suitCounter[3] > 4;
    }

    public static <T extends Collection<Card>> boolean HasMultiplePairs(T playerHand, T table, int largePairSize) {
        LinkedList<Card> cardLinkedList = new LinkedList<>(playerHand);
        cardLinkedList.addAll(table);
        cardLinkedList.sort(Card::compareTo);
        boolean largePairFound = false;
        boolean smallPairFound = false;
        try {
            if (HasXOfAKind(largePairSize, playerHand, table))
            for (int i = 0; i < cardLinkedList.size(); i++) {
                if (cardLinkedList.get(i).getRank().getRankValue() == cardLinkedList.get(i + 1).getRank().getRankValue()) {
                    if (!largePairFound && (largePairSize > 2 && cardLinkedList.get(i).getRank().getRankValue() == cardLinkedList.get(i + 2).getRank().getRankValue() || largePairSize == 2)) {
                        largePairFound = true;
                        i += largePairSize - 1;
                    } else {
                        smallPairFound = true;
                        i += 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return (largePairFound && smallPairFound);
        }
    }


    public static <T extends Collection<Card>> boolean HasStraightFlush(T playerHand, T table) {
        return HasStraight(playerHand, table) && HasFlush(playerHand, table);
    }

    public static <T extends Collection<Card>> boolean HasRoyalFlush(T playerHand, T table) {
        return HasStraightFlush(playerHand, table) && getHighCard(playerHand, table) == CardRank.ACE;
    }

    //TODO make sure high card in royal flush is the highest card of the flush (ex: A,Q,7,6,5,4,3 might be possible)
    //TODO hasMultiplePairs: if firstPairSize = 3, make sure an existing pair isn't skipped before finding the triple
}