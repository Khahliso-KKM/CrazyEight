package crazycards;

import java.util.ArrayList;
import java.util.Random;

public class Person {
    private final String playerName;
    private final int playerId;

    public Person(String name, int id){
        this.playerName = name;
        this.playerId = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }


}
