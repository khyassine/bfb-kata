package com.ykhatab;

import java.util.List;

public class Game {

    private final List<Player> players;
    private GameState state;

    public Game() {
        players = List.of(new Player("A"), new Player("B"));
        state = GameState.PLAYING;
    }

    public void newPointScoredBy(String playerName) {
        Player player = getPlayerByName(playerName);
        Player opponent = getOpponent(playerName);

        if (isWinSituation(player, opponent)) {
            if (playerName.equals("A")) {
                state = GameState.WON_A;
            } else {
                state = GameState.WON_B;
            }
            printWonMessage(playerName);
            return;
        }

        player.scoreNewPoint();

        if (state == GameState.DEUCE) {
            state = GameState.ADVANTAGE;
            player.setAdvantage(true);
            System.out.println("Player "+playerName+" gained advantage");
        }
        else if (isGameDeuce() || isGameAdvantageAndOpponentHasAdvantage(player, opponent)) {
            state = GameState.DEUCE;
            resetAdvantages();
            System.out.println("Game is in deuce");
        }
        printScore();
    }

    public void printScore() {
        System.out.println(this);
    }

    public boolean isGameDeuce() {
        return players
                .stream()
                .allMatch(player -> Score.DEUCE.getScore() == Score.calculateScoreFromPoints(player.getPoints()) && !player.hasAdvantage());
    }

    public GameState getState() {
        return state;
    }

    public boolean isGameWon() {
        return (state == GameState.WON_A || state == GameState.WON_B);
    }

    @Override
    public String toString() {
        int playerAScore = getPlayerScore(getPlayerByName("A"));
        int playerBScore = getPlayerScore(getPlayerByName("B"));
        return String.format("Player A : %s / Player B : %s", playerAScore, playerBScore);
    }

    private int getPlayerScore(Player player) {
        return Score.calculateScoreFromPoints(player.getPoints());
    }

    private Player getPlayerByName(String playerName) {
        return players.stream().filter(player -> player.getName().equals(playerName)).findFirst().get();
    }

    private Player getOpponent(String playerName) {
        return players.stream().filter(p -> !p.getName().equals(playerName)).findFirst().get();
    }

    private void resetAdvantages() {
        players.forEach(player -> player.setAdvantage(false));
    }

    private boolean isGameAdvantageAndOpponentHasAdvantage(Player player, Player opponent) {
        return state == GameState.ADVANTAGE && !player.hasAdvantage() && opponent.hasAdvantage();
    }

    private boolean isWinSituation(Player player, Player opponent) {
        return (player.getPoints() == 3 && player.getPoints() - opponent.getPoints() >= 1) || (player.hasAdvantage());
    }
    private void printWonMessage(String playerName) {
        System.out.printf("Player %s wins the game%n", playerName);
    }
}
