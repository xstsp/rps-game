package com.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pantazis
 */
public class GameResultsTest {
    
    GameResults results;
    int rounds;
            
    public GameResultsTest() {}
    
    @Before
    public void setUp() {
        System.out.println("Results initialised");
        results = new GameResults();
        rounds = 5;
    }

    @Test
    public void testPlayerA() {
        System.out.println("Testing player A");
        for (int i = 0 ; i < rounds ; i++) {
            results.playerAwon();
        }
        assertEquals(results.getPlayerAwins(), rounds);
    }

    @Test
    public void testPlayerB() {
        System.out.println("Testing player B");
        for (int i = 0 ; i < rounds ; i++) {
            results.playerBwon();
        }
        assertEquals(results.getPlayerBwins(), rounds);
    }

    @Test
    public void testTie() {
        System.out.println("Testing ties");
        for (int i = 0 ; i < rounds ; i++) {
            results.tied();
        }
        assertEquals(results.getTies(), rounds);
    }
    
}
