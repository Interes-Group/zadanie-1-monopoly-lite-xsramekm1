package sk.stuba.fei.uim.oop.monopoly;

import java.io.Console;
import java.util.Scanner;
import sk.stuba.fei.uim.oop.monopoly.Estates;

import static sk.stuba.fei.uim.oop.monopoly.Dice.diceRoll;
import static sk.stuba.fei.uim.oop.monopoly.Dice.prisonRoll;

public class Game {

    public static void monopolyGame(){
        Console console = System.console();
        if (console == null){
            Square[] fields = Estates.generateEstates();
            System.out.println("<<<<<<<<<<<<<<<<MONOPOLY LITE>>>>>>>>>>>>>>>>");
            System.out.println("version 1.0");
            System.out.println("how many nolifers want to play this amazing java console game?");
            Scanner scan = new Scanner(System.in);
            int player_count = 0;
            try {
                player_count =  Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Nezadal si integer ty mongol");
            }
            // player cannot play alone and more than 10 players is not reasonable for given board
            if(player_count <= 1 || player_count > 10) {
                System.out.println("neplatny pocet hracov");
            } else {
                System.out.println("looserov je " + player_count);
                Player[] players = new Player[player_count];
                for (int i = 0; i < player_count; i++){
                    System.out.println("Player " + (i+1) + " choose your name:");
                    String temp = scan.nextLine();
                    players[i] = new Player();
                    players[i].setName(temp);
                }
                System.out.println("Welcome, players: ");

                for (int i = 0; i < player_count; i++){
                    System.out.println(players[i].getName());
                }
                System.out.println("LET THE GAME BEGIN!!");
                System.out.println("::::♠♣♥♦::::  game commands: s - skip , b - buy, e - euro balance,f - forfeit, h-help   ::::♠♣♥♦::::");
                int j = 0;
                while(gameOver(player_count, players) == false){

                    int roll = diceRoll();
                    if (players[j%player_count].getPosition() == 6){
                        if (players[j%player_count].getJail_time() > 0){
                            System.out.println(players[j%player_count].getName() + " is in jail for " + players[j%player_count].getJail_time() +  " more turn(s)");
                            players[j%player_count].reduceJail_time();
                            j++;
                            continue;
                        } else {
                            System.out.println(players[j%player_count].getName() + " is finally free, fuck the popo! GET THE DOPE!");
                            players[j%player_count].setPosition(12);
                        }
                    }
                    players[j%player_count].setPosition(players[j%player_count].getPosition() + roll);
                    System.out.println((players[j%player_count].getName()) + " rolled the dice for: " + roll +
                            " and is now square: " + players[j%player_count].getPosition()%24 +
                            " aka " + fields[players[j%player_count].getPosition()%24].getName() +
                            " (retail price: " + fields[players[j%player_count].getPosition()%24].getRetail_price() + ")");
                    if (players[j%player_count].getPosition() == 12){
                        System.out.println("You are visiting maximum security prison so take a good look... and maybe reserve one of the rooms");
                    }
                    while(players[j%player_count].getPosition() >= 24){
                        System.out.println(":::::::::::   " + players[j%player_count].getName() + " crossed the starting line and is awarded 2000 euros   :::::::::::");
                        players[j%player_count].addBalance(2000);
                        players[j%player_count].setPosition(players[j%player_count].getPosition()-24);
                    }
                    if (fields[players[j%player_count].getPosition()].isPurchased()){
                        System.out.println("This property is owned by " + fields[players[j%player_count].getPosition()].getOwner() +
                                ". You are paying " + fields[players[j%player_count].getPosition()].getVisit_price() + "€ for the visit.");
                        players[fields[players[j%player_count].getPosition()].getOwner_id()].addBalance(fields[players[j%player_count].getPosition()].getVisit_price());
                        players[j%player_count].reduceBalance(fields[players[j%player_count].getPosition()].getVisit_price());
                    }
                    if (players[j%player_count].getPosition() == 6){
                        int prison_turn = prisonRoll();
                        System.out.println("You have been caught by special taskforce known as pedohunters and you are going to prison for " + prison_turn + " turn(s)");
                        players[j%player_count].setJail_time(prison_turn);
                    }

                   input_loop: while(true){
                        String input_command = scan.nextLine();
                        switch (input_command){
                            case "s":
                                j++;
                                break input_loop;
                            case "b":
                                //buy command

                                int pos = players[j%player_count].getPosition();
                                //porovnanie ci je policko kupitelne
                                if(fields[pos].getClass() == fields[1].getClass()){
                                    if (fields[pos].isPurchased() == false){
                                        if (fields[pos].getRetail_price() <= players[j%player_count].getBalance()){
                                            fields[pos].setOwner_id(j%player_count);
                                            fields[pos].setOwner(players[j%player_count].getName());
                                            fields[pos].setPurchased(true);
                                            players[j%player_count].reduceBalance(fields[pos].getRetail_price());
                                            System.out.println(players[j%player_count].getName() + " has purchased " + fields[pos].getName() + " for " + fields[pos].getRetail_price() + "€");
                                            continue;
                                        } else{
                                            System.out.println("You dont have enough money to buy " + fields[pos].getName());
                                        }
                                    } else {
                                        System.out.println(fields[pos].getName() + " cannot be purchased because its already owned by " + fields[pos].getOwner());
                                    }
                                } else{
                                    System.out.println(fields[pos].getName() + " cannot be bought");
                                }
                                continue;
                            case "e":
                                System.out.println("Your balance is: "+players[j%player_count].getBalance()+" €");
                                continue;
                            case "h":
                                System.out.println("::::♠♣♥♦::::  game commands: s - skip , b - buy, e - euro balance,f - forfeit, h-help   ::::♠♣♥♦::::");
                                continue;
                            case "f":
                                //forfeit
                                continue;
                        }
                        if(input_command != "s" && input_command != "b" && input_command != "e" && input_command != "h" && input_command != "f"){
                            System.out.println(input_command + " is not recognizable command. Available commands are: s - skip , b - buy, e - euro balance,f - forfeit, h-help");
                        }
                    }
                }
                for(int i = 0; i < player_count; i++){
                    if(players[i].getDefeatStatus() == false){
                        System.out.println("<<<<<<<<<<<<<<< ♛ Koniec hry, vyhral " + players[i].getName() + " so zostatkom: " + players[i].getBalance() + " ♛ >>>>>>>>>>>>>>>");
                    }
                }
            }



        }else{
            System.out.println("There is an error displaying console, file Game.java needs to be executed from command prompt.");
        }
    }

    private static boolean gameOver(int number_of_players, Player[] p) {
        int flag = 0;
        for (int i = 0; i < number_of_players; i++){
            if (p[i].getBalance() < 0 && p[i].getDefeatStatus() == false){
                // If we have 0 euros we can still play
                System.out.println(":::::::::::   " + p[i].getName() + " has bankrupted " + p[i].getBalance() + " and is out of the game   :::::::::::");
                p[i].setDefeatStatus(true);
                flag++;
                if (flag >= number_of_players - 1){
                    return true;
                }
            }
        }
        return false;
    }
}