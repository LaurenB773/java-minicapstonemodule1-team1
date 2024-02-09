package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Team {
    private final int BUDGET_CAP = 80_500_000;
    private String city;
    private String teamName;

    private List<Player> roster = new LinkedList<>();


    public int getBudgetCap() {
        int moneySpent = 0;
        for (Player player : roster) {
            moneySpent += player.getSalary();

        }
        return BUDGET_CAP - moneySpent;
    }

    public String getCity() {
        return city;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void joinRoster(Player player) {
        roster.add(player);
    }

    public String getTeamName() {
        return teamName;
    }

    public Team(String city, String teamName) {
        this.city = city;
        this.teamName = teamName;
    }

    public String getFullName() {
        return city + " " + teamName;
    }

//    public void addPlayersToTeamFromFile(Team team, File inputFile) { // make filereader
//        try (Scanner fileReader = new Scanner(inputFile)){
//
//            while(fileReader.hasNextLine()) {
//            String line = fileReader.nextLine();
//
//            // get player
//                Player newplayer = makePlayer(line);
//                this.roster.add(newplayer);
//            }
//
//
//
//        } catch (FileNotFoundException e){
//            System.out.println("filenotfound");
//        }
//
//    }

    /**
     * makePlayer reads a files line and splits it into an array, with array items it creates a new player.
     * @param playerLine
     * @return
     */
    public Player makePlayer(String playerLine) {
        String[] splitLine = playerLine.split("\\|");

        String playerName = splitLine[1] + " " + splitLine[2];

        if (splitLine[4].equals("Defense")) {
            DefensePlayer newPlayer = new DefensePlayer(Integer.parseInt(splitLine[0]),
                    playerName, splitLine[3], Integer.parseInt(splitLine[4]),
                    Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));

            return newPlayer;


        } else if(splitLine[4].equals("Offense")) {
            OffensivePlayer newPlayer = new OffensivePlayer(Integer.parseInt(splitLine[0]),
                    playerName, splitLine[3], Integer.parseInt(splitLine[4]),
                    Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));

            return newPlayer;

        }
        else if (splitLine[4].equals("Goalie")) {
            OffensivePlayer newPlayer = new OffensivePlayer(Integer.parseInt(splitLine[0]),
                    playerName, splitLine[3], Integer.parseInt(splitLine[4]),
                    Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));

            return newPlayer;

        }


        return null;

    }


    /**
     * maketeams should read entire folder containing team players and create the teams needed
     * @param inputFile
     * @return
     */
    public void makeTeams(File inputFile, List<Team> allTeams) {
        File[] teamFiles = inputFile.listFiles();


            String teamName;
            for(File each : teamFiles) {
                teamName = each.toString().split("\\_")[0]+" " + each.toString().split("\\_")[1];

                try (Scanner fileScanner = new Scanner(each)) {
                    fileScanner.nextLine();
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();

                        Player newPlayer = makePlayer(line);

                        for(Team team : allTeams) {
                            if (teamName.equals(team.getFullName())) {
                                roster.add(newPlayer);
                            }

                        }

                    }


                } catch (FileNotFoundException e) {
                    System.out.println("");
                }

            }

    }
    @Override
    public String toString(){
        String lala = this.getCity() + " " + this.getTeamName();
        return lala;
    }

}
