package com.game;

import com.game.Player.Strategy;

/**
 *
 * @author pantazis
 * 
 * Class Game defines a game of Rock, Paper, Scissors. 
 * It is initialized with two players with defined playing strategies and
 * the number of rounds to be played.
 * 
 */

public class Game {

    public enum RoundOutcome {
        WINFOR_A, WINFOR_B, TIE
    }
    
    private final Player playerA;
    private final Player playerB;
    private final int rounds;
    private GameResults results;

    public Game(Player playerA, Player playerB, int rounds) {
        this.playerA = playerA;
        this.playerB = playerB;
        if ( rounds <= 0 ) {
            // Will play at least one time!
            rounds = 1;
        }
        this.rounds = rounds;
        this.results = new GameResults();
    }
        
    public int getRounds() {
        return rounds;
    }
    
    public GameResults getResults() {
        return results;
    }

    public void play() {
        System.out.println("Game started!");
        for (int i = 0; i < this.rounds; i++) {
            System.out.println("Playing round " + (i + 1));
            this.playRound();
        }
    }

    public void printResults() {
        System.out.println("Player A wins " + results.getPlayerAwins() + " of " + this.rounds + " games");
        System.out.println("Player B wins " + results.getPlayerBwins() + " of " + this.rounds + " games");
        System.out.println("Tie: "          + results.getTies()        + " of " + this.rounds + " games");
    }

    private void playRound() {
        RoundOutcome winner = assessWinner(this.playerA.getStrategicMove(), this.playerB.getStrategicMove());
        switch (winner) {
            case WINFOR_A:
                this.results.playerAwon();
                System.out.println("Player A won!");
                break;
            case WINFOR_B:
                this.results.playerBwon();
                System.out.println("Player B won!");
                break;
            case TIE:
                this.results.tied();
                System.out.println("Tie!");
                break;
        }
    }

    private RoundOutcome assessWinner(Strategy strategyA, Strategy strategyB) {
        RoundOutcome outcome = RoundOutcome.TIE;
        System.out.println(strategyA + " VS " + strategyB);

        if (strategyA.equals(strategyB)) {
            return RoundOutcome.TIE;
        }

        switch (strategyA) {
            case SCISSORS:
                if (strategyB.equals(Strategy.ROCK)) {
                    outcome = RoundOutcome.WINFOR_B;
                } else {
                    outcome = RoundOutcome.WINFOR_A;
                }
                break;
            case ROCK:
                if (strategyB.equals(Strategy.PAPER)) {
                    outcome = RoundOutcome.WINFOR_B;
                } else {
                    outcome = RoundOutcome.WINFOR_A;
                }
                break;
            case PAPER:
                if (strategyB.equals(Strategy.SCISSORS)) {
                    outcome = RoundOutcome.WINFOR_B;
                } else {
                    outcome = RoundOutcome.WINFOR_A;
                }
                break;
        }
        return outcome;
    }

}
