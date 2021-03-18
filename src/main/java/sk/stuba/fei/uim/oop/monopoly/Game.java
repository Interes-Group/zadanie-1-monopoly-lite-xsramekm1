package sk.stuba.fei.uim.oop.monopoly;

import java.io.Console;
import java.util.Scanner;

import static sk.stuba.fei.uim.oop.monopoly.Dice.diceRoll;

public class Game {

    public static void monopolyGame(){
        Console console = System.console();
        if (console == null){
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
                    String input_command;
                    input_command = scan.nextLine();
                    switch (input_command){
                        case "s":
                            int roll = diceRoll();
                            players[j%player_count].setPosition(players[j%player_count].getPosition() + roll);
                            System.out.println((players[j%player_count].getName()) + " rolled the dice for: " + roll +
                                    " and is now square: " + players[j%player_count].getPosition()%24 + " aka " + squares[players[j%player_count].getPosition()%24]);
                            while(players[j%player_count].getPosition() >= 24){
                                System.out.println(":::::::::::   " + players[j%player_count].getName() + " crossed the starting line and is awarded 2000 euros   :::::::::::");
                                players[j%player_count].addBalance(2000);
                                players[j%player_count].setPosition(players[j%player_count].getPosition()-24);
                            }
                            j++;
                            continue;
                        case "b":
                            //buy command
                            continue;
                        case "e":
                            System.out.println("Your balance is: "+players[j%player_count].getBalance()+" €");
                            continue;
                        case "h":
                            System.out.println("::::♠♣♥♦::::  game commands: s - skip , b - buy, e - euro balance,f - forfeit, h-help   ::::♠♣♥♦::::");
                            continue;
                        case "f":
                            //forfeit
                            //continue;

                    }
                    if(input_command != "s" && input_command != "b" && input_command != "e" && input_command != "h" && input_command != "f"){
                        System.out.println(input_command + " is not recognizable command. Available commands are: s - skip , b - buy, e - euro balance,f - forfeit, h-help");
                    }


                    // co sa nachadza na policku, co by hrac rad urobil
                    j++;




                    //test kod
                    if (j > 40){
                        System.out.println(players[0].getName() + "ma zostatok" + players[0].getBalance());
                        players[0].setBalance(15000 - j*300);
                        System.out.println(players[0].getName() + "ma zostatok" + players[0].getBalance());
                    }
                    if (j > 80){
                        break;
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