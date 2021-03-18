package sk.stuba.fei.uim.oop.monopoly;

public class Estates {
    public static void generateEstates(){
        Estate[] fields = new Estate[20];
        int x = 0;
        for(int i = 0; i < 24; i++){
            if(i == 6 || i == 12 || i == 18){
                continue;
            }
            fields[x] = new Estate();
            fields[x].setId(i);
            fields[x].setRetail_price(x*400);
            fields[x].setVisit_price(x*80);
            x++;
        }
    }
}
