package sk.stuba.fei.uim.oop.monopoly;

import java.io.Console;
import java.util.Scanner;

public class Game {

    public static void main (String[] args){
        Console console = System.console();
        if (console != null){
            console.writer().println("<<<<<<<<<<<<<<<<MONOPOLY LITE>>>>>>>>>>>>>>>>");
            console.writer().println("version 1.0");
            console.writer().println("Choose your names...");

            System.out.println("Player 1:");
            String player_1 = console.readLine();
            System.out.println("Hello " + player_1 + ", welcome to the jungle!");
        }else{
            System.out.println("There is an error displaying console, file Game.java needs to be executed from command prompt.");
        }
    }
}
