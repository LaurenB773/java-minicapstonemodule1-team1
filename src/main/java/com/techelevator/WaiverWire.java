package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WaiverWire{

private List<Player> roster =new LinkedList<>();

private final String name = "Waiver Wire";




    public List<Player> getRoster() {
        return roster;
    }

    public void joinRoster(Player player) {
        roster.add(player);
    }

}
