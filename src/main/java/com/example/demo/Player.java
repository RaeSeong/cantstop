package com.example.demo;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Player {
    private final int id;
    private final Color color;
    private Basecamp basecamp;
    private HikingStick hikingStick;

    public Player(int id, Color color) {
        this.id = id;
        this.color = color;

        this.basecamp = new Basecamp();
    }
}
