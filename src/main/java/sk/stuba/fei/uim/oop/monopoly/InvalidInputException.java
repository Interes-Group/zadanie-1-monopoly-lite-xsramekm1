package sk.stuba.fei.uim.oop.monopoly;

public class InvalidInputException extends Exception{

    public InvalidInputException(){
        super("Invalid input");
    }

    public InvalidInputException(String message){
        super(message);
    }
}
