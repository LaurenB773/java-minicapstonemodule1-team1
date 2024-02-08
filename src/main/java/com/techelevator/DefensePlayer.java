package com.techelevator;

public class DefensePlayer extends Player{

    private int hits;
    private int blockedShots;

    public int getHits() {
        return hits;
    }

    public int getBlockedShots() {
        return blockedShots;
    }

    public DefensePlayer(int number, String name, String position, int salary, int hits, int blockedShots) {
        super(salary, number, position, name);
        this.hits = hits;
        this.blockedShots = blockedShots;
    }

}
