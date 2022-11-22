package crazycards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Cards {
    private ArrayList<String> cards = new ArrayList<>();
    private ArrayList<String> mainCards = new ArrayList<>();;
    private String table;

    private ArrayList<String> tableList = new ArrayList<>();

    public Cards(){
        startCards();
    }

    public void startCards(){
        setCards();
        setMainCards();
        shuffle();
        setTable();
        splitTable();

    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public String getTable(){
        return this.table;
    }
    public ArrayList<String> getMainCards(){
        return this.mainCards;
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

    private ArrayList<String> setMainCards(){
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

        this.mainCards.addAll(hearts);
        this.mainCards.addAll(diamonds);
        this.mainCards.addAll(spades);
        this.mainCards.addAll(flys);
        this.mainCards.add("JOKER_BLACK");
        this.mainCards.add("JOKER_RED");
        return this.mainCards;
    }

    private ArrayList<String> shuffle(){
        Collections.shuffle(this.cards);
        return this.cards;
    }

    public ArrayList<String> generatePlayerCards(){
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

    public void setTable(){
        Random random = new Random();
        int rand_number = random.nextInt(0, cards.size()-1);
        String rand_card = cards.get(rand_number);
        cards.remove(rand_card);
        this.table = rand_card;

    }

    public void updateTable(String table){
        this.table = table;
    }
    public boolean cardPlayed(String playingCard){
//        if(playingCard.equalsIgnoreCase("pick")){
//            //account for when player picks
//        }
        if(cardIsPlayable(playingCard)){
            updateTable(playingCard);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean cardIsPlayable(String card){
        ArrayList<String> splitCard = splitPlayingCard(card);
        String the_card_num = splitCard.get(0);
        String the_card_shape = splitCard.get(1);
        String the_table_num = tableList.get(0);
        String the_table_shape = tableList.get(1);
        if (the_card_shape.equalsIgnoreCase(the_table_shape)){
            return true;
        } else if (the_card_num.equalsIgnoreCase(the_table_num)) {
            return true;
        }
        else {
            return false;
        }
    }

    private ArrayList<String> splitPlayingCard(String card){
        ArrayList<String> splitPlayingCard = new ArrayList<String>(Arrays.asList(card.split("_")));
        return splitPlayingCard;
    }

    private void splitTable(){
        ArrayList<String> splitTable = new ArrayList<String>(Arrays.asList(table.split("_")));
        this.tableList = splitTable;
    }

    public ArrayList<String> getTableList(){
        return this.tableList;
    }
}
