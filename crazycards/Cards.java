package crazycards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cards {
    private ArrayList<String> cards = new ArrayList<>();

    public Cards(){
        startCards();
    }

    public void startCards(){
        setCards();
        shuffle();

    }

    public ArrayList<String> getCards() {
        return cards;
    }

    private ArrayList<String> setCards(){
        ArrayList<String> hearts = new ArrayList<>();
        ArrayList<String> flys = new ArrayList<>();
        ArrayList<String> spades = new ArrayList<>();
        ArrayList<String> diamonds = new ArrayList<>();


        for (int i=1; i<11; i++){
            hearts.add( i + "_HEART");
        }
        hearts.add("J_HEART");
        hearts.add("Q_HEART");
        hearts.add("K_HEART");


        for (int i=1; i<11; i++){
            flys.add( i + "_FLY");
        }
        flys.add("J_FLY");
        flys.add("Q_FLY");
        flys.add("K_FLY");


        for (int i=1; i<11; i++){
            spades.add( i + "_SPADE");
        }
        spades.add("J_SPADE");
        spades.add("Q_SPADE");
        spades.add("K_SPADE");


        for (int i=1; i<11; i++){
            diamonds.add( i + "_DIAMOND");
        }
        diamonds.add("J_DIAMOND");
        diamonds.add("Q_DIAMOND");
        diamonds.add("K_DIAMOND");

        this.cards.addAll(hearts);
        this.cards.addAll(diamonds);
        this.cards.addAll(spades);
        this.cards.addAll(flys);
        this.cards.add("JOKER_BLACK");
        this.cards.add("JOKER_RED");
        return this.cards;
    }

    private ArrayList<String> shuffle(){
        Collections.shuffle(this.cards);
        return this.cards;
    }

    private ArrayList<String> generatePlayerCards(){
        Random random = new Random();
        ArrayList<String> playerCards = new ArrayList<>();
        while (playerCards.size() != 6){
            int index = random.nextInt(0, cards.size()-1);
            String rand_card = cards.get(index);
            playerCards.add(rand_card);
            this.cards.remove(rand_card);
        }
        return playerCards;
    }

}
