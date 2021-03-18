package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.monopoly.Dice;
import sk.stuba.fei.uim.oop.monopoly.Game;



public class Assignment1 {


    public static void main(String[] args) {
        Game g = new Game();
        g.monopolyGame();
        for (int i = 0; i < 0; i++){
            System.out.println(Dice.diceRoll());
        }
    }
}

