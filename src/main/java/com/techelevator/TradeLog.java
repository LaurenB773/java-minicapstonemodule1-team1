package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TradeLog{
    private final String fileName = ("C:\\Users\\Student\\workspace\\capstones\\java-minicapstonemodule1-team1\\log.txt");

    File tradeLog = new File(fileName);


    public void createNewFile(){

        try(FileOutputStream fileWriter = new FileOutputStream(fileName, false);
            PrintWriter filePrinter = new PrintWriter(fileWriter)){

//                PrintWriter print = new PrintWriter(filePrinter);
//                print.print(tradeLog);

            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
   // Resets logger
    public TradeLog(){
        createNewFile();

    }

    private String getDateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss ");

        return now.format(formatter);
    }

    public void printPlayersToTradeConfirmed(Team team1, Team team2, List <Player> tradedPlayer, List <Player> tradedPlayer2){

        String logPlayersToTradeConfirmed = getDateTime() + " " + team1 + ", " + tradedPlayer + " <-> " + team2 + ", " + tradedPlayer2.toString() + " " + "Confirmed";


         try(FileOutputStream fileWriter = new FileOutputStream(fileName, true);
         PrintWriter filePrinter = new PrintWriter(fileWriter)){

             PrintWriter print = new PrintWriter(filePrinter);
             print.print(logPlayersToTradeConfirmed + "\n");

         }catch (IOException e){

         }
    }

    public void printPlayersToTradeDenied(Team team1, Team team2, List <Player> tradedPlayer , List <Player> tradedPlayer2){

           String logPlayersToTradeDenied = getDateTime() + " " + team1 + ", " + tradedPlayer + " <-> " + team2 + ", " + tradedPlayer2.toString() + " " + "Denied";
           try (FileOutputStream fileWriter = new FileOutputStream(fileName, true);
                PrintWriter filePrinter = new PrintWriter(fileWriter)) {

               PrintWriter print = new PrintWriter(filePrinter);
               print.print(logPlayersToTradeDenied + "\n");

           } catch (IOException e) {

           }

    }
    public void printWaivedPlayer(Team team, Player waivedPlayer){

        String logWaivedPlayer = getDateTime() + " " + team + ", " + waivedPlayer + " -- " + "Waived";

        try(FileOutputStream fileWriter = new FileOutputStream(fileName, true);
            PrintWriter filePrinter = new PrintWriter(fileWriter)){

            PrintWriter print = new PrintWriter(filePrinter);
            print.print(logWaivedPlayer + "\n");

        }catch (IOException e){

        }
    }
    public void printClaimedWaivedPlayer(Team team, Player waivedPlayer){
        String logClaimedWaivedPlayer = getDateTime() + " " + team + ", " + waivedPlayer.getName() + " -- " + "Claimed";
        try(FileOutputStream fileWriter = new FileOutputStream(fileName, true);
            PrintWriter filePrinter = new PrintWriter(fileWriter)){

            PrintWriter print = new PrintWriter(filePrinter);
            print.print(logClaimedWaivedPlayer + "\n");

        }catch (IOException e) {
        }
    }


//    public String tradeContentToString(List<Player> tradeContent) {
//        String oops = null;
//
//            for (Player each : tradeContent) {
//                if (tradeContent.indexOf(each) == tradeContent.size() - 1) {
//                    oops = oops + each.getName();
//                } else {
//
//                    oops = oops + each.getName() + ", ";
//                }
//            }
//        return oops;
//    }
}
