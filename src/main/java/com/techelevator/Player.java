package com.techelevator;

import java.util.Comparator;

public abstract class Player implements IHasStats{
    private int salary;
    private int number;
    private String position;
    private String name;

    public Player(int salary, int number, String position, String name) {
        this.salary = salary;
        this.number = number;
        this.position = position;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String listPlayerStatsLimited() {
        return (getNumber() + ") " + getName() + " " + getPosition() + " " + getSalary());
    }


}
