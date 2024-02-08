package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Application application = new Application();
        application.run();

    }

    public void run(){
        File fileToRead = new File("TeamData");

        List<Team> allTeams= teamSplitter(fileToRead);


    }

    public List<Team> teamSplitter(File fileToRead) {

        File[] teamFiles = fileToRead.listFiles();
        List<Team> allTeams = new ArrayList<>();


        // if team has same name as before add to team roster but if it does not make new list and override teamname
        String firstFilesName = teamFiles[0].getName();

        for (int i = 0; i < teamFiles.length; i++) {

            String fileString = teamFiles[i].getName();

            String cityName = fileString.substring(0, firstFilesName.indexOf("\\_"));
            String teamName = fileString.split("\\_")[1];

            if (!allTeams.contains(cityName)) {

                Team team = new Team(cityName, teamName);
                allTeams.add(team);
            }

        }
        return allTeams;
    }












}
