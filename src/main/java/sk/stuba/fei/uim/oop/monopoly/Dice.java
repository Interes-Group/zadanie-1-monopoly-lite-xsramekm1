package sk.stuba.fei.uim.oop.monopoly;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static int diceRoll(){
        /*Random rand = new Random();
        int rand_int = 0;
        do{
            rand_int = rand_int + rand.nextInt(6);
            rand_int = rand_int + 1;
        }
        while (rand_int % 6 == 0);
        return rand_int;*/
        System.out.println("how much do you want to roll?");
        Scanner scan = new Scanner(System.in);
        int roll;
        roll = Integer.parseInt(scan.nextLine());
        return roll;
    }

    public static int prisonRoll(){
        Random rand = new Random();
        int rand_int =  rand.nextInt(2);
        rand_int += 1;
        return rand_int;
    }

    public static int chanceRoll(){
        Random rand = new Random();
        int rand_int =  rand.nextInt(3);
        return rand_int;
    }
}
