package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    UI userInterface = new UI();

    Trade trade = new Trade();

    FindPlayer playerFinder = new FindPlayer();

    public static void main(String[] args) {


        Application application = new Application();
        application.run();

    }

    public void run(){
        File fileToRead = new File("TeamData");

        boolean running = true;
        List<Team> allTeams= teamSplitter(fileToRead);
        System.out.println(allTeams);

//        WaiverWire waiverWire = new WaiverWire();
        makeTeams(fileToRead, allTeams);
        Team WaiverWire = new Team("Waiver", "Wire");
        allTeams.add(WaiverWire);

        while (running) {
            String choice = userInterface.menu();
            boolean validChoice = false;
            while (!validChoice) {
                switch (choice) {
                    case "1":
                        userInterface.displayTeams(allTeams);
                        validChoice = true;
                        break;

                    case "2":
                        trade.tradePlayer(allTeams);
                        validChoice = true;
                        break;
                    case "3":
                        Team waiverWire = allTeams.get(allTeams.size()- 1);
                        if(!(waiverWire.getRoster().size() == 0)) { // if waiver wire is not empty
                            userInterface.displayWaiverWire(waiverWire, allTeams);
                            validChoice = true;
                            break;
                        } else {
                            System.out.println("No free agents available!");
                            validChoice = true;
                            break;
                        }
                    case "4": // done
                        System.out.println("Enter a string to search for your player");
                        String playerToFind = userInterface.choosePlayer();
                        playerFinder.findPlayer(allTeams, playerToFind);
                        validChoice = true;
                        break;

                    case "5":

                        validChoice = true;
                        running = false;
                        System.out.println("Goodbye Coach!");
                        break;
                    default:
                        System.out.println("Please only select numbers 1 through 5");
                        choice = userInterface.menu();
                        break;
                }
            }
        }
    }

    public List<Team> teamSplitter(File fileToRead) {

        File[] teamFiles = fileToRead.listFiles();
        List<Team> allTeams = new ArrayList<>();


        // if team has same name as before add to team roster but if it does not make new list and override teamname
        String firstFilesName = teamFiles[0].getName();

        for (int i = 0; i < teamFiles.length; i = i + 3) {

            String fileString = teamFiles[i].getName();

            String cityName = fileString.split("\\_")[0];
            String teamName = fileString.split("\\_")[1];

                Team team = new Team(cityName, teamName);
                allTeams.add(team);


        }

        return allTeams;
    }


    /**
     * makePlayer reads a files line and splits it into an array, with array items it creates a new player.
     * @param playerLine
     * @return
     */
    public Player makePlayer(String playerLine) {
        String[] splitLine = playerLine.split("\\|");

        String playerName = splitLine[1] + " " + splitLine[2];

        if (splitLine[3].equals("Defense")) {
            DefensePlayer newPlayer = new DefensePlayer(Integer.parseInt(splitLine[0]),
                    playerName, splitLine[3], Integer.parseInt(splitLine[4]),
                    Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));

            return newPlayer;


        } else if(splitLine[3].equals("Forward")) {
            OffensivePlayer newPlayer = new OffensivePlayer(Integer.parseInt(splitLine[0]),
                    playerName, splitLine[3], Integer.parseInt(splitLine[4]),
                    Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));

            return newPlayer;

        }
        else if (splitLine[3].equals("Goalie")) {
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
                        if (teamName.contains(team.getFullName())) {
                            team.joinRoster(newPlayer);
                            break;
                        }

                    }

                }


            } catch (FileNotFoundException e) {
                System.out.println("");
            }

        }

    }











}
