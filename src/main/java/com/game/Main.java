package com.game;

import com.game.Player.Strategy;
/**
 *
 * @author pantazis
 */

public class Main {

    /**
     * Create a new Game. 
     * Mandatory arguments for the game to begin are:
     *  - the two players, with their strategies defined
     *      - available options: SCISSORS, ROCK, PAPER, RANDOM
     *  - how many rounds to be played
     */
    
    public static void main(String[] args) {        
        
        Player playerA = new Player("A");
        Player playerB = new Player("B");
        
        playerA.defineStrategy(Strategy.ROCK);
        playerB.defineStrategy(Strategy.RANDOM);
        
        Game game = new Game(playerA, playerB, 100);
        game.play();
        game.printResults();
        
    }
}
