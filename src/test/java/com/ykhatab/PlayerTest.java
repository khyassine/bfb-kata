package com.ykhatab;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest {

    private static final String PLAYER_NAME = "Player_Test_NAME";
    private static Player player;

    @BeforeAll
    static void setUp(){
        player = new Player(PLAYER_NAME);
    }

    @Test
    @Order(0)
    void givenTennisPlayer_WhenPlayerIsCreated_ThenReturnCorrectInstantiationValues(){
        //given

        //when
        int playerScore = Score.calculateScoreFromPoints(player.getPoints());
        String actualPlayerName = player.getName();

        //then
        Assertions.assertEquals(PLAYER_NAME, actualPlayerName);
        Assertions.assertEquals(Score.ZERO.getScore(), playerScore);
    }

    @Test
    @Order(1)
    void givenTennisPlayer_WhenPlayerScoresNewPoint_ThenReturnCorrectScoreValue(){
        //given

        //when
        player.scoreNewPoint();
        int playerScore = Score.calculateScoreFromPoints(player.getPoints());

        //then
        Assertions.assertEquals(Score.ONE.getScore(), playerScore);
    }

    @Test
    @Order(3)
    void givenTennisPlayer_WhenPlayerScoresMultipleNewPoints_ThenReturnCorrectScoreValue(){
        //given

        //when
        player.scoreNewPoint();
        player.scoreNewPoint();
        int playerScore = Score.calculateScoreFromPoints(player.getPoints());

        //then
        Assertions.assertEquals(Score.DEUCE.getScore(), playerScore);
    }

}
