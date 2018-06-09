package com.game;

/**
 *
 * @author pantazis
 * 
 * Class GameResults stores the total results of a game
 * 
 */

public class GameResults {
    private int playerAwins;
    private int playerBwins;
    private int ties;

    public GameResults() {
        playerAwins = 0;
        playerBwins = 0;
        ties = 0;
    }
    
    public void playerAwon() {
        this.playerAwins++;
    }
    
    public void playerBwon() {
        this.playerBwins++;
    }
    
    public void tied() {
        this.ties++;
    }
    
    public int getPlayerAwins() {
        return this.playerAwins;
    }
    
    public int getPlayerBwins() {
        return this.playerBwins;
    }
    
    public int getTies() {
        return this.ties;
    }
}
