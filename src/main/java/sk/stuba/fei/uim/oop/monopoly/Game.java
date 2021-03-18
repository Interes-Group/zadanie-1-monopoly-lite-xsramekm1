package sk.stuba.fei.uim.oop.monopoly;

import java.io.Console;
import java.util.Scanner;

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
            }
            while(gameOver(player_count, players[]) == false){

            }
        }else{
            System.out.println("There is an error displaying console, file Game.java needs to be executed from command prompt.");
        }
    }

    private static boolean gameOver(int number_of_players, Class Player[]) {
        int flag = 0;
            for (int i = 0; i < number_of_players; i++){
                if (Player[i].isDefeatStatus()){
                     flag++;
                     if (flag >= number_of_players - 1){
                         return true;
                     }
                     System.out.println(Player[i].isDefeatstatus());
            }
        }
    }
}