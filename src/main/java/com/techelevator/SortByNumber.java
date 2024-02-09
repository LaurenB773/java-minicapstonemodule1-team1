package com.techelevator;

import java.util.Comparator;

public class SortByNumber implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        return player1.getNumber() - player2.getNumber();
    }
}
