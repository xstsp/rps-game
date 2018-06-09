package com.game;

import java.util.Random;

/**
 *
 * @author pantazis
 * 
 * Class player models a game player, with a certain name and specific strategy.
 * The available strategies to choose from are strictly defined in Strategy enum.
 * 
 */

public class Player {
    
    public enum Strategy {
        SCISSORS, ROCK, PAPER, RANDOM
    }
    
    final String name;
    private Strategy strategy;
    private Random randomGenerator;

    public Player(String name) {
        this.name = name;
        this.strategy = Strategy.RANDOM;
    }
    
    public void defineStrategy(Strategy strategy) {
        // Don't mind invalid input - Let's play randomly!
        if ( strategy == null || strategy.equals(Strategy.RANDOM) ) {
            randomGenerator = new Random();
            strategy = Strategy.RANDOM;
        }
        this.strategy = strategy;
    }
    
    public Strategy getStrategicMove() {
        if ( this.strategy.equals(Strategy.RANDOM) ) {
            // Choose only among SCISSORS, ROCK, PAPER
            int index = this.randomGenerator.nextInt(Strategy.values().length - 1);
            return Strategy.values()[index];
        }
        return this.strategy;
    }
    
    public Strategy getStrategy(){
        return this.strategy;
    }
    
    public void handleRandomness(long seed) {
        randomGenerator.setSeed(seed);
    }
    
}
