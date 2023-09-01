package com.example.demo;

import java.util.Arrays;
import java.util.Map;

public class Basecamp {
    private int[] height = new int[11];

    public Basecamp(){
        Arrays.fill(this.height, 0);
    }
    public int[] getHeight() {
        return height;
    }

    public int getHeight(int index){
        return height[index];
    }

    public int[] setBasecamp(Map<Integer, Integer> hikingStick) {
         for(int key: hikingStick.keySet()){
             this.height[key] = hikingStick.get(key);
         }
         return this.height;
    }

    public void destroyBasecamp(int index){
        this.height[index] = 0;
    }
}
