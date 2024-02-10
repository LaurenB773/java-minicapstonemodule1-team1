package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
public class TradeLog {
    private static final String SEPARATOR = "\t\t\t";
    private String fileName = "log.txt";
    File teamData = new File("TeamData");
    File tradeLog = new File(fileName);




//    //Log item
//    public void printTradeLog(List<Team> allTeams, List<Player> player){
//        printDateTime();
//        printPlayersToTradeConfirmed();
//        printPlayersToTradeDenied();
//        printWaivedPlayer();
//        printClaimedWaivedPlayer();
    public void createNewFile(){

        //I don't think I need to go through the TeamData folder I just don't know what to do yet
        try (Scanner fileReader = new Scanner(teamData);
             PrintWriter printWriter = new PrintWriter(fileName)) {

            printWriter.println();




        } catch(FileNotFoundException e){
            System.out.println("Sorry file not found");
        }


    }
    

    private String getDateTime(){
        return LocalDateTime.now().toString();
    }

    private void printPlayersToTradeConfirmed(){
    //01/01/2019 12:00:00 PM Team Name Player Name, Player Name <-> Team Name Player Name Confirmed
    }
    private void printPlayersToTradeDenied(){
    //01/01/2019 12:00:10 PM Team Name Player Name <-> Team Name Player Name Denied
    }
    private void printWaivedPlayer(){
    //01/01/2019 12:00:15 PM Team Name Player Name -- Waived
    }
    private void printClaimedWaivedPlayer(){
    //01/01/2019 12:00:30 PM Team Name Player Name -- Claimed
    }


}
