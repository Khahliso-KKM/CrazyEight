package crazycards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Person {
    private final String playerName;
    private final int playerId;
    private ArrayList<String> playerCards;
    private ArrayList<String> mainCards;

    public Person(String name, int id, ArrayList<String> mainCards){
        this.playerName = name;
        this.playerId = id;
        this.mainCards = mainCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setCards(ArrayList<String> theCards){
        this.playerCards = theCards;
    }

    public ArrayList<String> getPlayerCards(){
        return this.playerCards;
    }

    public String play(String table){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println(playerCards);
            System.out.println("Your turn to play!!!\nThe Table is: "+table+"\nWhat would you like to play?");
            String playingCard = scanner.next();
            if(playingCard.equalsIgnoreCase("pick")){
                return "pick";
            }
            if (formatIsValid(playingCard)){
                if(cardIsInPlayerCards(playingCard)){
                    return playingCard.toUpperCase();
                }
                else {
                    System.out.println("Please play a card that is in your set of cards");
                    System.out.println(playerCards);
                }
            }
            else {
                System.out.println("Please check your spelling and the format of the card..");
            }
        }

    }

    private boolean cardIsInPlayerCards(String card){
        if(playerCards.contains(card)){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean formatIsValid(String card){
        if(mainCards.contains(card)){
          return true;
        }
        else{
            return false;
        }
    }

    public void removeCard(String card){
        playerCards.remove(card);
    }
}
