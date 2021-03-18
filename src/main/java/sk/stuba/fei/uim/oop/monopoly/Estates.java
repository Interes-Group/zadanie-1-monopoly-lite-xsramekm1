package sk.stuba.fei.uim.oop.monopoly;

public class Estates {
    public static void generateEstates(){
        //Estate[] fields = new Estate[20];
        Square[] fields = new Square[24];
        fields[1] = new Estate();
        fields[2] = new Estate();
        fields[3] = new Estate();
        fields[4] = new Estate();
        fields[5] = new Estate();

        fields[7] = new Estate();
        fields[8] = new Estate();
        fields[9] = new Estate();
        fields[10] = new Estate();
        fields[11] = new Estate();

        fields[13] = new Estate();
        fields[14] = new Estate();
        fields[15] = new Estate();
        fields[16] = new Estate();
        fields[17] = new Estate();

        fields[19] = new Estate();
        fields[20] = new Estate();
        fields[21] = new Estate();
        fields[22] = new Estate();
        fields[23] = new Estate();
        fields[23].setRetail_price(400);
        fields[23].setVisit_price(80);


        int x = 0;
        for(int i = 0; i < 24; i++){
            if(i == 6 || i == 12 || i == 18){
                continue;
            }
            fields[x].setId(i);
            fields[x].setRetail_price(x*400);
            fields[x].setVisit_price(x*80);
            x++;
        }
        fields[0].setName("Hrdzavá vaňa na záhrade");
        fields[1].setName("Betónová skruža");
        fields[2].setName("Drevená kadibúdka");
        fields[3].setName("Zatuchnutá pivnica");
        fields[4].setName("Deravá hamaka");
        fields[5].setName("Psia búda");
        fields[6].setName("Starý favorit");
        fields[7].setName("Hodinový motel");
        fields[8].setName("Garzónka v pentagone");
        fields[9].setName("Villa v Prievidzi");
        fields[10].setName("Uránová baňa");
        fields[11].setName("Aljašké igloo");
        fields[12].setName("Compton drug house");
        fields[13].setName("Beduinsky stan");
        fields[14].setName("Ropná plošina");
        fields[15].setName("Rumunské ocelárne");
        fields[16].setName("Bel Air bungalov");
        fields[17].setName("Koloseum");
        fields[18].setName("Burj Khalifa");
        fields[19].setName("Pyramída v Gize");

    }

}

