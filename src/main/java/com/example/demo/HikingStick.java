package com.example.demo;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class HikingStick {
    private Map<Integer, Integer> routeHeight;

    public HikingStick(){
        this.routeHeight = new HashMap<Integer,Integer>();
    }

    public void hikingOneHeight(int index){
        this.routeHeight.put(index, Optional.ofNullable(this.routeHeight.get(index)).orElse(0) + 1);
    }

    public void setHikingStickOnBasecamp(int index, int basecamp){
        this.routeHeight.put(index, basecamp);
    }
}
