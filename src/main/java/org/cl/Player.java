package org.cl;

import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand;
    ArrayList<ArrayList<Card>> melds;

    public Player(String playerName) {
        hand = new ArrayList<Card>();
        melds = new ArrayList<ArrayList<Card>>();
        name = playerName;
    }

    @Override
    public String toString() {
        return name + ", # of Cards: " + hand.size();
    }

    public void orderHandByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();

        for (String cardValue : new String[]{"Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        }) {
            for (Card card : hand) {
                if (card.value == cardValue) {
                    newHand.add(card);
                }
            }
        }

        hand = newHand;
    }

    public void orderHandBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();

        for (String cardSuit : new String[]{"Clubs", "Diamonds", "Hearts", "Spades"}) {
            for (Card card : hand) {
                if (card.value == cardSuit) {
                    newHand.add(card);
                }
            }
        }

        hand = newHand;
    }

    public void printStatus() {
        System.out.println("---" + name + "---");
        System.out.println("  " + hand);
        System.out.println("  Melds: " + melds);
    }
    public static void main(String[] args) {
        Player p1 = new Player("Jessica");
        System.out.println(p1.toString());
    }
}
