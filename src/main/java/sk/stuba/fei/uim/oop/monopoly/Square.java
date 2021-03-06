package sk.stuba.fei.uim.oop.monopoly;

public class Square {
    int id;
    String name;

    //estate
    int retail_price;
    int visit_price;
    boolean purchased = false;
    String owner;
    // ked nebolo pridelene default bol 0 (co je player cislo 1)
    int owner_id = 780;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //ESTATES
    public int getRetail_price() {
        return retail_price;
    }

    public int getVisit_price() {
        return visit_price;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public String getOwner() {
        return owner;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }

    public void setVisit_price(int visit_price) {
        this.visit_price = visit_price;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
