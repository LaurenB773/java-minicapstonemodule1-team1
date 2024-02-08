package com.techelevator;

import java.util.List;
import java.util.Scanner;



public class UI {
    private final Scanner userInput = new Scanner(System.in);



    public void tradePlayer() { // TODO:

    }

    public void cutPlayer() {

    }

    public void signPlayer() {

    }

    public void menu() {
        System.out.println();
        System.out.println("(1) Display Teams");
        System.out.println("(2) Make a Trade");
        System.out.println("(3) Sign Free Agent");
        System.out.println("(4) Find Player");
        System.out.println("(5) Exit");
        System.out.println();

        System.out.print("Make Selection: ");
        String choice = userInput.nextLine();


    }
    public void displayTeams(List<Team> allTeams, List<Player> waiverWireRoster){ // use tabs whateva dafuq that means
        int fuckWaiverWire = 1;
        for (int i = 0; i < allTeams.size(); i++) {
            Team currentTeam = allTeams.get(i);
            int numberOfPlayers = currentTeam.getRoster().size();
            System.out.println((i +1) + ") " + allTeams.get(i) + " Players: " + numberOfPlayers);
            fuckWaiverWire++;
        }
        System.out.println(fuckWaiverWire + ") Waiver Wire" + " Players: " + waiverWireRoster.size());

    }


}
