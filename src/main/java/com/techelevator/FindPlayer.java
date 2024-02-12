package com.techelevator;

import java.util.List;
import java.util.Locale;

public class FindPlayer {

    public void findPlayer(List<Team> allTeams, String search) {

        boolean playerFound = false;
        for (Team each : allTeams) {

            System.out.println();
            System.out.println(each.getFullName());
            System.out.println("=====================");
            playerFound = false;
                for (Player eachPlayer : each.getRoster()) {

                    String playerName = eachPlayer.getName();
                    String playerPosition = eachPlayer.getPosition();
                    if (playerName.toLowerCase().contains(search) || playerName.toUpperCase().contains(search) || playerName.contains(search)) { // would only take case sensitive prompts
                        System.out.println(eachPlayer.listPlayerStatsLimited());
                        playerFound = true;
                    }
                    if (playerPosition.toLowerCase().contains(search) || playerPosition.toUpperCase().contains(search) || playerPosition.contains(search)) {
                        System.out.println(eachPlayer.listPlayerStatsLimited());
                        playerFound = true;
                    }


                }
                if (!playerFound) {
                    System.out.println("No players found from search here");
                }

        }
    }


}
