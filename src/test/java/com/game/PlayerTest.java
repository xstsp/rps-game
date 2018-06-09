package com.game;

import org.junit.Test;
import static org.junit.Assert.*;
import com.game.Player.Strategy;

/**
 *
 * @author pantazis
 */
public class PlayerTest {
    
    Player player;
    
    public PlayerTest() {
        player = new Player("test");
    }

    @Test
    public void testDefineStrategy() {
        System.out.println("Test define strategy");
        for (Strategy strategy : Strategy.values()) {
            player.defineStrategy(strategy);
            assertEquals(player.getStrategy(), strategy);            
        }
    }
    
    @Test
    public void testDefineStrategicMoveNotRandom() {
        System.out.println("Test define strategic move");
        Strategy strategy;
        for (int i = 0 ; i < Strategy.values().length - 1 ; i++) {
            strategy = Strategy.values()[i];
            player.defineStrategy(strategy);
            assertEquals(player.getStrategicMove(), strategy);
            assertEquals(player.getStrategicMove(), player.getStrategy());
        }
    }
     
    @Test
    public void testRandomStrategy() {
        System.out.println("Test random strategy");
        player.defineStrategy(Strategy.RANDOM);
        player.handleRandomness(10000);
        // strategic move is different to strategy RANDOM
        assertNotEquals(player.getStrategicMove(), player.getStrategy());
        // strategic move is selected randomly
        assertEquals(player.getStrategicMove(), Strategy.ROCK);
    }
    
    @Test
    public void testDefineNullStrategy() {
        System.out.println("Test null strategy");
        player.defineStrategy(null);
        assertEquals(player.getStrategy(), Strategy.RANDOM);
    }
    
    @Test
    public void testNoStrategySet() {
        System.out.println("Test no strategy set");
        player = new Player("test");
        assertEquals(player.getStrategy(), Strategy.RANDOM);
    }

}
