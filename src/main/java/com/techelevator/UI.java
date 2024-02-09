package com.techelevator;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.Scanner;



public class UI {
    private final Scanner userInput = new Scanner(System.in);

    SortByNumber playerSorter = new SortByNumber();

    public void tradePlayer() { // TODO:

    }

    public void signPlayer() {

    }

    public String menu() {
        System.out.println();
        System.out.println("(1) Display Teams");
        System.out.println("(2) Make a Trade");
        System.out.println("(3) Sign Free Agent");
        System.out.println("(4) Find Player");
        System.out.println("(5) Exit");
        System.out.println();

            System.out.print("Make Selection: ");
            String choice = userInput.nextLine();


        return choice;

    }
    public void displayTeams(List<Team> allTeams){

        int fuckyouwaiverwire = 0;
        for (int i = 0; i < allTeams.size(); i++) {
            Team currentTeam = allTeams.get(i);
            int numberOfPlayers = currentTeam.getRoster().size();
            if(i != allTeams.size() - 1) {
                System.out.println((i + 1) + ") " + allTeams.get(i) + " Players: " + numberOfPlayers + "     Cap Space: " + currentTeam.getBudgetCap());
            } else {
                System.out.println((i + 1) + ") " + allTeams.get(i) + " Players: " + numberOfPlayers);
            }
            fuckyouwaiverwire++;
        }
        System.out.println();
        System.out.println();



        System.out.println("Enter a number to select a team, enter 'Q' for quit");
        String choice = userInput.nextLine();


        if (!choice.equalsIgnoreCase("q")) {
            int selection = Integer.parseInt(choice);

            // choose team and show every one of their player stats limited
            displayRoster(allTeams.get(selection - 1), allTeams.get(fuckyouwaiverwire - 1));
        }


    }

    public void displayRoster(Team team, Team waiverWire) {

        team.getRoster().sort(playerSorter);

        for (Player each : team.getRoster()) {
            System.out.println(each.listPlayerStatsLimited());

        }


        System.out.println();
        System.out.print("Choose a Player by number: ");
        int choice = Integer.parseInt(userInput.nextLine());

        Player selected = null;

        for (Player each : team.getRoster()) {
            if(each.getNumber() == choice){
                each.fullStatLine();
                selected = each;
                break;
            }
        }
        System.out.println(selected.fullStatLine());
        Player cutPlayer = displayCutPlayer(selected, team);
        waiverWire.joinRoster(cutPlayer);
    }

    public void displayWaiverWire(Team waiverWire, List<Team> allTeams) {
        waiverWire.getRoster().sort(playerSorter);

        for (Player each : waiverWire.getRoster()) {
            System.out.println(each.listPlayerStatsLimited());

        }

        System.out.println("Choose a player to sign");
        System.out.println();
        int chosenPlayerNumber = Integer.parseInt(userInput.nextLine());
        // save chosen player
        Player chosenPlayer = null;
        for(Player each : waiverWire.getRoster()) {
            if (each.getNumber() == chosenPlayerNumber) {
                chosenPlayer = each;
                break;
            }
        }

        //choose team of player list all teams first

        for (int i = 0; i < allTeams.size() - 1; i++) {

            System.out.println((i + 1) + ") " + allTeams.get(i));

        }

        System.out.println();
        System.out.print("Choose a team to sign the player: ");
        int chosenTeam = Integer.parseInt(userInput.nextLine());
        Team chosenTeamActually = allTeams.get(chosenTeam-1);


        // check logic method
        System.out.println("Sign player? (Y/N)");
        String choices = userInput.nextLine();


        Player removedPlayer = null;
        boolean correctChoice = false;
        while (!correctChoice) {
            if (choices.equalsIgnoreCase("y")) {
                int playerIndex = waiverWire.getRoster().indexOf(chosenPlayer); // make me the right index not the poopootown
                removedPlayer = waiverWire.getRoster().remove(playerIndex);
                correctChoice = true;

            } else if (choices.equalsIgnoreCase("n")) {

                correctChoice = true;
            }
        }
        if(checkLogic(chosenTeamActually, removedPlayer.getSalary())) { // if it can pass all checks involving cap space and team room
            // if true
            System.out.println("Player signed!");
            chosenTeamActually.joinRoster(removedPlayer);
        } else {
            // if false
            System.out.println("You can't do that");
            waiverWire.joinRoster(removedPlayer);
        }



    }
    public Player displayCutPlayer(Player playerToCut, Team playerTeam) {
        System.out.println("Cut player? (Y/N)");
        String choice = userInput.nextLine();

        boolean correctChoice = false;
        while (!correctChoice) {
            if (choice.equalsIgnoreCase("y")) {
                int playerIndex = playerTeam.getRoster().indexOf(playerToCut);
                Player removedPlayer = playerTeam.getRoster().remove(playerIndex);
                correctChoice = true;
                return removedPlayer;

            } else if (choice.equalsIgnoreCase("n")) {

                correctChoice = true;
                return null;
            }
        }

        return null;
    }

    public boolean checkLogic(Team teamToCheck, int playerCost) { // for one team
        if (teamToCheck.getRoster().size() <= 23 &&
        teamToCheck.getBudgetCap() > playerCost) {
            return true;
        }
        return false;
    }

//    public boolean checkLogic(Team buyingTeam, Team sellingTeam) { // for trade
//
//
//    }

}
