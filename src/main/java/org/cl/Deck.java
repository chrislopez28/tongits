package org.cl;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    String[] suits = new String[]{ "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] values = new String[]{ "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    public Deck() {
        cards = new ArrayList<Card>();
        for (String suit:suits) {
            for (String value:values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (Card card:deck.getCards()) {
            System.out.println(card.toString());
        }
    }
}
