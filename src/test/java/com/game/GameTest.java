package com.game;

import org.junit.Test;
import static org.junit.Assert.*;
import com.game.Player.Strategy;

/**
 *
 * @author pantazis
 */
public class GameTest {
    
    Game game;
    Player playerA;
    Player playerB;
    
    public GameTest() {
        playerA = new Player("testA");
        playerB = new Player("testB");
    }

    @Test
    public void testGameSetup() {
        System.out.println("game setup");
        playerA.defineStrategy(Strategy.PAPER);
        playerB.defineStrategy(Strategy.ROCK);
        
        game = new Game(playerA, playerB, -1);
        assertEquals(game.getRounds(), 1);
        
        GameResults results = new GameResults();
        assertEquals(game.getResults().getPlayerAwins(), results.getPlayerAwins());
        assertEquals(game.getResults().getPlayerBwins(), results.getPlayerBwins());
        assertEquals(game.getResults().getTies(), results.getTies());
    }
   
    @Test
    public void testPlayPaper() {
        System.out.println("play paper");
        playerA.defineStrategy(Strategy.PAPER);
        playerB.defineStrategy(Strategy.ROCK);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 1);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        
        playerB.defineStrategy(Strategy.SCISSORS);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 1);
        
        playerB.defineStrategy(Strategy.PAPER);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        assertEquals(game.getResults().getTies(), 1);
    }
    
    @Test
    public void testPlayRock() {
        System.out.println("play rock");
        playerA.defineStrategy(Strategy.ROCK);
        playerB.defineStrategy(Strategy.SCISSORS);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 1);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        
        playerB.defineStrategy(Strategy.PAPER);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 1);
        
        playerB.defineStrategy(Strategy.ROCK);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        assertEquals(game.getResults().getTies(), 1);
    }

    @Test
    public void testPlayScissors() {
        System.out.println("play scissors");
        playerA.defineStrategy(Strategy.SCISSORS);
        playerB.defineStrategy(Strategy.PAPER);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 1);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        
        playerB.defineStrategy(Strategy.ROCK);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 1);
        
        playerB.defineStrategy(Strategy.SCISSORS);
        game = new Game(playerA, playerB, 1);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 0);
        assertEquals(game.getResults().getTies(), 1);
    }
    
    @Test
    public void testPrintResults() {
        System.out.println("printResults");
        playerA.defineStrategy(Strategy.PAPER);
        playerB.defineStrategy(Strategy.SCISSORS);
        game = new Game(playerA, playerB, 100);
        game.play();
        assertEquals(game.getResults().getPlayerAwins(), 0);
        assertEquals(game.getResults().getPlayerBwins(), 100);
        assertEquals(game.getResults().getTies(), 0);
        assertEquals(game.getRounds(), 100);
    }
    
    @Test
    public void testGameRandomStrategies() {
        System.out.println("random strategies");
        playerA.defineStrategy(Strategy.RANDOM);
        playerB.defineStrategy(Strategy.RANDOM);
        game = new Game(playerA, playerB, 1000);
        game.play();
        assertTrue(game.getResults().getPlayerAwins() > 0);
        assertTrue(game.getResults().getPlayerBwins() > 0);
        assertTrue(game.getResults().getTies() > 0);
        assertEquals(game.getRounds(), 1000);
    }
    
}
