package sk.stuba.fei.uim.oop.monopoly;

import java.util.Random;

public class Dice {
    public static int diceRoll(){
        Random rand = new Random();
        int rand_int = 0;
        do{
            rand_int = rand_int + rand.nextInt(6);
            rand_int = rand_int + 1;
        }
        while (rand_int % 6 == 0);
        return rand_int;
    }

    public static int prisonRoll(){
        Random rand = new Random();
        int rand_int =  rand.nextInt(2);
        rand_int += 1;
        return rand_int;
    }
}
