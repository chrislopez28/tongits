package org.cl;

import java.util.ArrayList;

public class Game {
    Deck deck;
    ArrayList<Player> players;
    int dealerIndex;
    int turnIndex;
    int moveNumber;

    public Game() {
        deck = new Deck();
        deck.shuffle();

        players = new ArrayList<Player>();
        dealerIndex = 0;
        turnIndex = 0;
        moveNumber = 1;
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

    public void incrementTurn() {
        moveNumber++;
        if (turnIndex == 2) {
            turnIndex = 0;
            return;
        }

        turnIndex++;
    }

    public void nextTurn() {
        System.out.println();
        System.out.println("*** Turn " + moveNumber + ": " + players.get(turnIndex).name + " ***");
        incrementTurn();
        pressEnterToContinue();
    }

    private void pressEnterToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
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

        for (Player player : game.players) {
            player.orderHandByValue();
            player.printStatus();
        }

        while (true) {
            game.nextTurn();
        }
    }
}
