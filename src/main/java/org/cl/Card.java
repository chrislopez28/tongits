package org.cl;

import java.util.ArrayList;
import java.util.Map;

public class Card {
    String suit;
    String value;
    public static Map<String, String> suitMap = Map.of(
        "Clubs", "C",
        "Diamonds", "D",
        "Hearts", "H",
        "Spades", "S"
    );

    public static Map<String, String> valueMap = Map.ofEntries(
            Map.entry("Ace", "A"),
            Map.entry("Two", "2"),
            Map.entry("Three", "3"),
            Map.entry("Four", "4"),
            Map.entry("Five", "5"),
            Map.entry("Six", "6"),
            Map.entry("Seven", "7"),
            Map.entry("Eight", "8"),
            Map.entry("Nine", "9"),
            Map.entry("Ten", "T"),
            Map.entry("Jack", "J"),
            Map.entry("Queen", "Q"),
            Map.entry("King", "K")
    );
    public Card(String cardSuit, String cardValue) {
        suit = cardSuit;
        value = cardValue;
    }

    @Override
    public String toString() {
        return valueMap.get(value) + suitMap.get(suit);
    }

    public String toStringFull() {
        return value + " of " + suit;
    }

    public static ArrayList<Card> orderCardsByValue(ArrayList<Card> cards) {
        ArrayList<Card> newList = new ArrayList<Card>();

        for (String cardValue : new String[]{"Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        }) {
            for (Card card : cards) {
                if (card.value == cardValue) {
                    newList.add(card);
                }
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        System.out.println("org.cl.Card");
        Card x = new Card("Spades", "Ace");
        System.out.println(x.toString());
    }
}
