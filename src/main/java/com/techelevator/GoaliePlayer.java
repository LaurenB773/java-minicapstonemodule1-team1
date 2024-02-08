package com.techelevator;

public class GoaliePlayer extends Player{
    private int shotAgainst;
    private int saves;
    public GoaliePlayer(int number, String name, String position, int salary, int shotAgainst, int saves) {
        super(salary, number, position, name);
        this.shotAgainst = shotAgainst;
        this.saves = saves;
    }

    public int getShotAgainst() {
        return shotAgainst;
    }

    public int getSaves() {
        return saves;
    }
}
