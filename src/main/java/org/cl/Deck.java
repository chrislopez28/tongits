package org.cl;

import java.util.ArrayList;
import java.util.Random;

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

    public Card dealCard() {
        if (cards.size() == 0) return null;

        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        int r;
        Card temp;

        for (int i = cards.size() - 1; i > 0; i--) {
            Random rand = new Random();
            r = rand.nextInt(i);
            temp = cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        for (Card card:deck.getCards()) {
            System.out.println(card.toString());
        }
    }
}
