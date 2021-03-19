package sk.stuba.fei.uim.oop.monopoly;

public class Animal {
    void saySomething() {System.out.print(" Hummmmm!");}
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

class Cow extends Animal {
    protected void saySomething() {System.out.print(" oMooo!");}

    String owner = "kebab";

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

class test {
    public static void main(String [] args) {
        System.out.print(" MooYa!");
        Animal [] animals = {new Animal(), new Cow()};
        for( Animal a : animals) {
            a.saySomething();
        }
        Animal animal = new Cow();
        Cow cow = (Cow)animal;
        System.out.println(cow.getOwner());
    }
}
