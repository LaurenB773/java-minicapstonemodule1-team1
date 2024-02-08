package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Team {
    private final int budgetCap = 80_500_000;
    private String city;
    private String teamName;

    private List<Player> roster = new LinkedList<>();


    public int getBudgetCap() {
        return budgetCap;
    }

    public String getCity() {
        return city;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team(String city, String teamName) {
        this.city = city;
        this.teamName = teamName;
    }

    public void addPlayersToTeamFromFile(Team team, File inputFile) { // make filereader
        try (Scanner fileReader = new Scanner(inputFile)){

            while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            // get player
                Player newplayer = makePlayer(line);
                this.roster.add(newplayer);
            }



        } catch (FileNotFoundException e){
            System.out.println("filenotfound");
        }

    }

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
    public Team[] makeTeams(File inputFile) {
        try{
            Scanner fileReader = new Scanner(inputFile);

            while(fileReader.hasNextLine()){

            }





        }catch (FileNotFoundException e){
            System.out.println("oops");
        }

    }

}
