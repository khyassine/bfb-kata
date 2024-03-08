package com.ykhatab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCounterAppTest
{

    @Test
    void givenAAB_WhenGameIsFinished_ThenGameStateMustBePlaying(){
        //given
        String gameSequence = "AAB";
        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.PLAYING, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 30 / Player B : 15", gameLauncher.gameScore());
    }

    @Test
    void givenBBB_WhenGameIsFinished_ThenGameStateMustBePlaying(){
        //given
        String gameSequence = "BBB";
        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.PLAYING, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 0 / Player B : 40", gameLauncher.gameScore());
    }

    @Test
    void givenAAAA_WhenGameIsFinished_ThenPlayerAWinsTheGame(){
        //given
        String gameSequence = "AAAA";

        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_A, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 0", gameLauncher.gameScore());
    }

    @Test
    void givenBBBB_WhenGameIsFinished_ThenPlayerBWinsTheGame(){
        //given
        String gameSequence = "BBBB";

        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_B, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 0 / Player B : 40", gameLauncher.gameScore());
    }

    @Test
    void givenABABAA_WhenGameIsFinished_ThenPlayerAWins(){
        //given
        String gameSequence = "ABABAA";
        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_A, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 30", gameLauncher.gameScore());
    }

    @Test
    void givenAAABBBA_WhenGameIsFinished_ThenGameStateReturnsAdvantage(){
        //given
        String gameSequence = "AAABBBA";

        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.ADVANTAGE, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 40", gameLauncher.gameScore());

    }

    @Test
    void givenAAABBBAB_WhenGameIsFinished_ThenGameStateIsBackToDeuceAfterAdvantage(){
        //given
        String gameSequence = "AAABBBAB";

        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.DEUCE, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 40", gameLauncher.gameScore());

    }

    @Test
    void givenAAABBBA_WhenGameIsFinished_ThenPlayerAWinsTheGameAfterAdvantage(){
        //given
        String gameSequence = "AAABBBAA";

        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_A, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 40", gameLauncher.gameScore());

    }

    @Test
    void givenAAABBBAABBBBBBB_WhenGameIsFinished_ThenPlayerAWinsTheGameAfterAdvantage(){
        //given
        String gameSequence = "AAABBBAABBBBBBB";

        //when
        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_A, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 40", gameLauncher.gameScore());
    }

    @Test
    void givenAAABBBABABABAAB_WhenGameIsFinished_ThenPlayerAWinsTheGameAfterMultiplesDeuce(){
        //given
        String gameSequence = "AAABBBABABABAAB";

        //when
        GameLauncher gameLauncher = new GameLauncher(gameSequence);

        //when
        gameLauncher.start();

        //then
        Assertions.assertEquals(GameState.WON_A, gameLauncher.getGameState());
        Assertions.assertEquals("Player A : 40 / Player B : 40", gameLauncher.gameScore());
    }

}
