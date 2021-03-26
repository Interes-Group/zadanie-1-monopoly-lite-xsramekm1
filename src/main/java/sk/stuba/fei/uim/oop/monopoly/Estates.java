package sk.stuba.fei.uim.oop.monopoly;

public class Estates {
    public static Square[] generateEstates(){

        Square[] fields = {
                new Square(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(), //5

                new Police(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Jail(),  //12

                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Chance(), //18

                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(),
                new Estate(), //23
        };


        int x = 0;
        for(int i = 0; i < 24; i++){
            if(i == 6 || i == 12 || i == 18){
                continue;
            }
            fields[i].setRetail_price(x*400);
            fields[i].setVisit_price(x*80);
            x++;
        }
        fields[1].setName("Hrdzavá vaňa na záhrade");
        fields[2].setName("Betónová skruža");
        fields[3].setName("Drevená kadibúdka");
        fields[4].setName("Zatuchnutá pivnica");
        fields[5].setName("Deravá hamaka");
        fields[7].setName("Psia búda");
        fields[8].setName("Starý favorit");
        fields[9].setName("Hodinový motel");
        fields[10].setName("Garzónka v pentagone");
        fields[11].setName("Villa v Prievidzi");
        fields[13].setName("Uránová baňa");
        fields[14].setName("Aljašské igloo");
        fields[15].setName("Compton drug house");
        fields[16].setName("Beduinsky stan");
        fields[17].setName("Ropná plošina");
        fields[19].setName("Rumunské ocelárne");
        fields[20].setName("Bel Air bungalov");
        fields[21].setName("Koloseum");
        fields[22].setName("Burj Khalifa");
        fields[23].setName("Pyramída v Gize");

        fields[0].setName("Start");
        fields[6].setName("Los Santos Police Department");
        fields[12].setName("Supermax prison");
        fields[18].setName("Chance");


        return fields;
    }
}

