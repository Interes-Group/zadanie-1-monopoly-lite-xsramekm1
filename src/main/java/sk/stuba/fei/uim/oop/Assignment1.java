package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.monopoly.Dice;
import sk.stuba.fei.uim.oop.monopoly.Game;

public class Assignment1 {
    //Game.monopolyGame();
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++){
            System.out.println(Dice.diceRoll());
        }
    }
}

