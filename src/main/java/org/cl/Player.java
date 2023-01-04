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
    public static void main(String[] args) {
        Player p1 = new Player("Jessica");
        System.out.println(p1.toString());
    }
}
