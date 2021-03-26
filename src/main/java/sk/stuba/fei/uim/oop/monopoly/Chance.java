package sk.stuba.fei.uim.oop.monopoly;

public class Chance extends Square{
    static int outcome = 0;
    public static void chanceStep(Player[] p, int player_id, Square[] fields){
    // zaplat dane, chod do vazenia, dostan cash, chod na start
    int biggestEstate;
    switch (outcome){
        case 0:
            System.out.println("You stepped on chance square and you were awarded free 5000€");
            p[player_id].addBalance(5000);
            outcome++;
            break;
        case 1:
            System.out.println("You stepped on chance square and you are going back to start");
            p[player_id].setPosition(0);
            outcome++;
            break;
        case 2:
            System.out.println("You stepped on chance square and you were sent to jail for 1 turn");
            p[player_id].setJail_time(1);
            p[player_id].setPosition(12);
            outcome++;
            break;
        case 3:
            System.out.println("You stepped on chance square and were sent to jail for 2 turns");
            p[player_id].setJail_time(2);
            p[player_id].setPosition(12);
            outcome++;
            break;
        case 4:
            System.out.println("You stepped on chance square and you were awarded free 7000€");
            p[player_id].addBalance(7000);
            outcome++;
            break;
        case 5:
            System.out.println("You stepped on chance square and you are being investigated by police department, you are paying 3000€ bribe");
            p[player_id].reduceBalance(3000);
            outcome++;
            break;
        case 6:
            System.out.println("New hipster trend about sustainability influenced price of rusty bathtubs and concrete pipes. Visit prices have been increased 8 times");
            fields[1].setVisit_price(fields[1].getVisit_price()*8);
            fields[2].setVisit_price(fields[2].getVisit_price()*8);
            outcome++;
            break;
        case 7:
            biggestEstate = findBiggestEstate(player_id, fields);
            int j = player_id+1;
            System.out.println("You stepped on chance square and mafia found out about your estates, you are giving your largest estate(" + fields[biggestEstate].getName() + ")to player next to you");
            while(p[j].getDefeatStatus()) {
                j++;
                if(j == 10){
                    j = 0;
                }
            }
                fields[biggestEstate].setOwner_id(j);
                fields[biggestEstate].setOwner(p[j].getName());
            outcome++;
            break;
        case 8:
            System.out.println("You stepped on chance square and elevators in Burj Khalifa stopped working, everyones stay is doubled (double visit price)");
            fields[22].setVisit_price(fields[22].getVisit_price()*2);
            outcome++;
            break;
        case 9:
            System.out.println("You stepped on chance square and NAKA found out that you didnt pay any taxes. You are paying 10% of all your estates");
            int sum = 0;
            for(int i = 23; i != 0; i--){
                if (fields[i].getOwner_id() == player_id){
                    sum += fields[i].getRetail_price()/10;
                }
            }
            p[player_id].reduceBalance(sum);
            outcome++;
            break;
        case 10:
            biggestEstate = findBiggestEstate(player_id, fields);
            System.out.println("You stepped on chance square and you convinced Elon Musk to build hyperloop in your biggest estate. Visit price of " + fields[biggestEstate].getName() + " is doubled");
            fields[biggestEstate].setVisit_price(fields[biggestEstate].getVisit_price()*2);
            outcome++;
            break;
        case 11:
            biggestEstate = findBiggestEstate(player_id, fields);
            System.out.println("You stepped on chance square and your biggest Estate " + fields[biggestEstate].getName() + " was hit by earthquake, everything is destroyed and visit price is now 5€");
            fields[biggestEstate].setVisit_price(5);
            outcome++;
            break;
        case 12:
            System.out.println("Due to a climate change the Alaskan igloo has melted down. In order to build a new one " + fields[14].getOwner() +
                    " needs to purchase 10 refrigerators in total cost of 9000€");
            p[fields[14].getOwner_id()].reduceBalance(9000);
            outcome = 0;
            break;
    }



}
    public static int findBiggestEstate(int user_id, Square[] fields){
        //System.out.println("findBiggestEstate user_id: " + user_id);
        for(int i = 23; i != 0; i--){
            if (fields[i].getOwner_id() == user_id){
                return i;
            } else {
              /*  System.out.println("findBiggestEstate user_id: " + user_id);
                System.out.println("findBiggestEstate fields[i].getOwner_id() :" + fields[i].getOwner_id());*/
            }
        }
        return 0;
    }
}
