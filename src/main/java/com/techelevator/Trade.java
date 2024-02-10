package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trade {
    private final Scanner userInput = new Scanner(System.in);

    SortByNumber playerSorter = new SortByNumber();

    public void tradePlayer(List<Team> allTeams){

        List<Player> playersWanted = new ArrayList<>();
        List<Player> playersGiving = new ArrayList<>();

        Team selectedTeam =  displayTeamsTrade(allTeams);

        boolean wantMore = true;
        while (wantMore) {
            playersWanted.add(choosePlayerFromTeam(selectedTeam));
            System.out.println();
            System.out.print("Would you like to select another player? (Y/N)");
            String morePlayers = userInput.nextLine();

            if (morePlayers.equalsIgnoreCase("n")) {
                wantMore = false;
            } else {

            }

        }

        System.out.println();
        System.out.println("Select Team to Trade to");
        System.out.println();
        Team selectedTeam2 = displayTeamsTrade(allTeams);

        // if same team reprompt
        boolean rightAnswer = false;
        while (!rightAnswer) {

            if (!selectedTeam2.equals(selectedTeam)) {
                rightAnswer = true;
            } else {
                System.out.println("Team has to be a different team than first choice");
            }
        }

        boolean wantMore2 = true;
        while (wantMore2) {
            playersGiving.add(choosePlayerFromTeam(selectedTeam2));
            System.out.println();
            System.out.println("Would you like to select another player? (Y/N)");
            String morePlayers = userInput.nextLine();

            if (morePlayers.equalsIgnoreCase("n")) {
                wantMore2 = false;
            } else {

            }

        }

        tradeContentDisplay(playersGiving, playersWanted);
        System.out.println();
        System.out.println("Confirm trade? (Y/N)");
        String yesOrNo = userInput.nextLine();

        if (yesOrNo.equalsIgnoreCase("n")) {
            return;
        } else { // todo logic
            if (yesOrNo.equalsIgnoreCase("y")){
               boolean confirmTrade = tradeLogic(selectedTeam.getBudgetCap(), selectedTeam2.getBudgetCap(), selectedTeam.getRoster().size(), selectedTeam2.getRoster().size(), playersWanted, playersGiving);
               for(Player each : playersWanted) {
                   selectedTeam.getRoster().remove(each);
                   selectedTeam2.getRoster().add(each);
               }
               for(Player each : playersGiving){
                   selectedTeam2.getRoster().remove(each);
                   selectedTeam.getRoster().add(each);
               }

<<<<<<< HEAD
            }
=======
//            boolean confirmTrade = tradeLogic();
            // todo add to file
>>>>>>> 2cfcaf759a624fdbe0919d476a3fc989cab525b4

        }
    }

    public void tradeContentDisplay(List<Player> giving, List<Player> receiving){
        System.out.println();
        System.out.println("Players to give: ");
        for (Player each : giving){
            System.out.println(each.listPlayerStatsLimited());
        }
        System.out.println("><");
        System.out.println("Players to receive: ");
        for(Player each : receiving){
            System.out.println(each.listPlayerStatsLimited());
        }
    }
    public Team displayTeamsTrade(List<Team> allTeams){

        for (int i = 0; i < allTeams.size() - 1; i++) {
            Team currentTeam = allTeams.get(i);
            int numberOfPlayers = currentTeam.getRoster().size();
                System.out.println((i + 1) + ") " + allTeams.get(i) + " Players: " + numberOfPlayers + "     Cap Space: " + currentTeam.getBudgetCap());

        }
        System.out.println();
        System.out.println();

        System.out.println("Enter a number to select a team, enter 'Q' for quit");
        String choice = userInput.nextLine();

        Team selectedTeam = null;
        if (!choice.equalsIgnoreCase("q")) {
            int selection = Integer.parseInt(choice);
            selectedTeam = allTeams.get(selection - 1);

            selectedTeam.getRoster().sort(playerSorter);

            for (Player each : selectedTeam.getRoster()) {
                System.out.println(each.listPlayerStatsLimited());

            }

        }
        return selectedTeam;


    }

    public Player choosePlayerFromTeam(Team selectedTeam){
        for (Player each : selectedTeam.getRoster()){
           String line = each.listPlayerStatsLimited();
            System.out.println(line);
        }

        System.out.println();
        System.out.println();
        System.out.println("Please choose a player: ");
        int playerSelection = Integer.parseInt(userInput.nextLine());

        for (Player each : selectedTeam.getRoster()){
            if(each.getNumber() == playerSelection){
                return each;
            }

        }
        System.out.println("Player not found :( ");
        return null;
    }

    public boolean tradeLogic(int capTeam1, int capTeam2, int teamSize1, int teamSize2, List<Player> team1, List<Player> team2) {
      int teamOneSalary = 0;
        for (Player each : team1){
           int playerSalary = each.getSalary();
           teamOneSalary = playerSalary + teamOneSalary;
        }

        int teamTwoSalary = 0;
        for (Player each : team2){
            int playerSalary = each.getSalary();
            teamTwoSalary = playerSalary + teamOneSalary;
        }
        if(capTeam1 >= teamOneSalary && capTeam2 >= teamTwoSalary && teamSize1 < 23 && teamSize2 < 23) {
            return true;
            }
            return false;
            //make the trade is cap1 > List <player> get salary && if team1 < 23
            //&
            //make the trade is cap2 > List <player> get salary && if team2 < 2
            //, int teamSize1, int teamSize2
    }

}

