package com.ykhatab;

import java.util.Arrays;

public enum Score {
    ZERO(0, 0),
    ONE(1, 15),
    TWO(2, 30),
    DEUCE(3, 40);

    private final int points;
    private final int score;
    Score(int points, int score) {
        this.points = points;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static int calculateScoreFromPoints(int points){
        return Arrays.stream(values())
                .filter(score1 -> score1.points == points)
                .findFirst()
                .map(Score::getScore)
                .orElseThrow(()->new IllegalArgumentException("Invalid number of points."));
    }
}
