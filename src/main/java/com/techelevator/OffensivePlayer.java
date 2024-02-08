package com.techelevator;

public class OffensivePlayer extends Player{
    private int goals;
    private int assists;

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public OffensivePlayer(int number, String name, String position, int salary, int goals, int assists) {
        super(salary, number, position, name);
        this.goals = goals;
        this.assists = assists;
    }
}
