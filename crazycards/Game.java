package crazycards;

import Movements.Help;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static String playername;
    private static int playerid;
    private static ArrayList<Integer> existingIDs = new ArrayList<>();
    private static Help help = new Help();
    private static final Cards cards = new Cards();


    public static void main(String[] args) {
        playername = getPlayerName();
        playerid = generateID();
        Person person = new Person(playername, playerid);

        if (needHelp(playername)){
            help.howToPlay();
        }

        System.out.println("Cards shuffling... \n...\n...");

//        cards



    }

    public static boolean needHelp(String name){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hey "+name+ ". Need help on how to play this game?\n" +
                "Enter 'yes' for a quick how to play guidance, otherwise enter 'no':");
        String help = scan.next().toLowerCase();
        if (help.equalsIgnoreCase("yes")){
            return true;
        }
        else {
            return false;
        }
    }

    public static String getPlayerName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the game of Crazy8.\n" +
                "What's your name?");
        String name = scan.next();
        return name;
    }

    public static int generateID(){
        Random random = new Random();
        int id = 0;

        while (true){
            for (int i=0; i<3; i++){
                int rand_number = random.nextInt(0,9);
                id = id + rand_number;
            }
            if (!existingIDs.contains(id)){
                existingIDs.add(id);
                break;
            }

        }
        return id;
    }
}
