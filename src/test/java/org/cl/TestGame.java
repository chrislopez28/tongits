package org.cl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestGame {

    @Test
    @DisplayName("isSameValue")
    void isSameValue() {
        Card c1 = new Card("Spades", "Ace");
        Card c2 = new Card("Hearts", "Ace");
        Card c3 = new Card("Clubs", "Ace");
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);

        assertEquals(true, Game.isSameValue(testHand));
    }

    @Test
    void isSameSuit() {
    }

    @Test
    void getPrevCardValue() {
    }

    @Test
    void getNextCardValue() {
    }

    @Test
    void isConsecutive() {
    }

    @Test
    void isMeld() {
    }
}