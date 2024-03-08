package com.ykhatab;

public class GameLauncher {

    private final Game tennisGame;
    private final String gameSequence;

    public GameLauncher(String gameSequence) {
        this.tennisGame = new Game();
        this.gameSequence = gameSequence;
    }

    public void start(){
        for(char playerName : gameSequence.toCharArray()){
            if(!tennisGame.isGameWon()){
                tennisGame.newPointScoredBy(String.valueOf(playerName));
            }
        }
    }
    
    public GameState getGameState(){
        return tennisGame.getState();
    }

    public String gameScore(){
        return tennisGame.toString();
    }
    
}
