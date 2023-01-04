package org.cl;

import java.util.ArrayList;

public class Game {
    Deck deck;
    ArrayList<Player> players;
    int dealerIndex;

    public Game() {
        deck = new Deck();
        deck.shuffle();

        players = new ArrayList<Player>();
        dealerIndex = 0;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void dealCards() {
        for (int i = 0; i < 12; i++) {
            for (Player p : players) {
                p.hand.add(deck.dealCard());
            }
        }

        players.get(dealerIndex).hand.add(deck.dealCard());
    }

    public static void main(String[] args) {
        Game game = new Game();

        ArrayList<Player> players = new ArrayList<Player>();
        game.addPlayer(new Player("Annalisa"));
        game.addPlayer(new Player("Emile"));
        game.addPlayer(new Player("Jessica"));

        System.out.println("Welcome to Tong-its");

        game.dealCards();

        for (Player player : game.players) {
            System.out.println(player.toString());
        }

        System.out.println(game.deck.getCards());

    }
}
