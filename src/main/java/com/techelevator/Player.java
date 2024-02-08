package com.techelevator;

public abstract class Player {
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



}
