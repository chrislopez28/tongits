package org.cl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

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

    public static boolean isSameValue(ArrayList<Card> testMeld) {
        String firstValue = testMeld.get(0).value;

        for (Card card : testMeld) {
            if (card.value != firstValue) return false;
        }

        return true;
    }

    public static boolean isSameSuit(ArrayList<Card> testMeld) {
        String firstSuit = testMeld.get(0).suit;

        for (Card card : testMeld) {
            if (card.suit != firstSuit) return false;
        }

        return true;
    }

    public static String getPrevCardValue(String cardValue) {
        switch (cardValue) {
            case "Two":
                return "Ace";
            case "Three":
                return "Two";
            case "Four":
                return "Three";
            case "Five":
                return "Four";
            case "Six":
                return "Five";
            case "Seven":
                return "Six";
            case "Eight":
                return "Seven";
            case "Nine":
                return "Eight";
            case "Ten":
                return "Nine";
            case "Jack":
                return "Ten";
            case "Queen":
                return "Jack";
            case "King":
                return "Queen";
            case "Ace":
                return "King";
            default:
                return "Invalid Suit";
        }
    }

    public static String getNextCardValue(String cardValue) {
        switch (cardValue) {
            case "Ace":
                return "Two";
            case "Two":
                return "Three";
            case "Three":
                return "Four";
            case "Four":
                return "Five";
            case "Five":
                return "Six";
            case "Six":
                return "Seven";
            case "Seven":
                return "Eight";
            case "Eight":
                return "Nine";
            case "Nine":
                return "Ten";
            case "Ten":
                return "Jack";
            case "Jack":
                return "Queen";
            case "Queen":
                return "King";
            case "King":
                return "Ace";
            default:
                return "Invalid Suit";
        }
    }

    public static boolean isConsecutive(ArrayList<Card> testMeld) {
        ArrayList<Card> arrList = Card.orderCardsByValue(testMeld);
        int length = arrList.size();

        if ( arrList.get(0).value == "Two" && arrList.get(length - 1).value == "Ace" ) {
            Card endingAce = arrList.get(length - 1);
            arrList.add(0, endingAce);
            arrList.remove(arrList.size() - 1);
        }

        String expectedCardValue = "";

        for (int i = 0; i < arrList.size() - 1; i++) {
            if (i != 0) {
                if (expectedCardValue != arrList.get(i).value) {
                    return false;
                }
            }
            expectedCardValue = getNextCardValue(arrList.get(i).value);
        }

        return true;
    }



    public static boolean isMeld(ArrayList<Card> testMeld) {
        if (testMeld.size() < 3) return false;

        if (isConsecutive(testMeld) && isSameSuit(testMeld)) return true;

        if (isSameValue(testMeld)) return true;

        return false;
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
            System.out.println(isMeld(game.deck.getCards()));
            game.nextTurn();
        }
    }
}
