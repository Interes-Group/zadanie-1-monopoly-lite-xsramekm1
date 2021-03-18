package sk.stuba.fei.uim.oop.monopoly;

public class Player {
    String name = "";
    private int balance = 15000;
    public boolean defeatStatus = false;
    public int position = 0;


    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void addBalance(int addBalance) {
        this.balance += addBalance;
    }

    public boolean getDefeatStatus() {
        return defeatStatus;
    }

    public void setDefeatStatus(boolean defeatStatus) {
        this.defeatStatus = defeatStatus;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}





