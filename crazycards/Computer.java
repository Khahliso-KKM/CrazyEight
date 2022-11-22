package crazycards;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer {
    private final String computerName;
    private ArrayList<String> computerCards;
    private ArrayList<String> mainCards;

    public Computer(String name, ArrayList<String> mainCards){
        this.computerName = name;
        this.mainCards = mainCards;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setCards(ArrayList<String> theCards){
        this.computerCards = theCards;
    }

    public ArrayList<String> getComputerCards(){
        return this.computerCards;
    }

    public String play(){
//        while (true){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("What would you like to play?");
//            String playingCard = scanner.next();
//            if (formatIsValid(playingCard)){
//                if(cardIsInPlayerCards(playingCard)){
//                    return playingCard;
//                }
//                else {
//                    System.out.println("Please play a card that is in your set of cards");
//                    System.out.println(playerCards);
//                }
//            }
//            else {
//                System.out.println("Please check spelling and format of the card..");
//            }
//        }
        return "";
    }

    private boolean cardIsInPlayerCards(String card){
        if(computerCards.contains(card)){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean formatIsValid(String card){
        System.out.println(mainCards.size());
        if(mainCards.contains(card)){
            return true;
        }
        else{
            return false;
        }
    }
}
