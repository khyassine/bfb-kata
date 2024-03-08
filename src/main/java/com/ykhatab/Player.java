package com.ykhatab;

public class Player {

    private String name;
    private int points;

    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public void scoreNewPoint() {
        if (points < 3) {
            points++;
        }
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }
}
