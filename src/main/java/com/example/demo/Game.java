package com.example.demo;

import lombok.Getter;
import java.util.List;

@Getter
public class Game {
    private List<Player> playerList;

    private Mountain mountain;

    public Game(List<Player> playerList){
        this.playerList = playerList;
        this.mountain = new Mountain();
    }
}
