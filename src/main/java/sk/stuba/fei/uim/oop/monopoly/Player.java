package sk.stuba.fei.uim.oop.monopoly;

public class Player {
    String name = "";
    private int balance = 15000;
    boolean defeatStatus = false;

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

    public boolean getDefeatStatus() {
        return defeatStatus;
    }

    public void setDefeatStatus(boolean newDefeatStatus) {
        this.defeatStatus = newDefeatStatus;
    }
}


