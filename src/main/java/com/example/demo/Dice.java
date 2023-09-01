package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Dice {
    public static int role() {
        return (int)(Math.random()*60)%6 + 1;
    }

    public static Map<Integer, Integer> getCombination(int[] dices) {
        Map<Integer, Integer> combinationMap = new HashMap<Integer, Integer>();
        for(int i=0; i < dices.length; i++){
            for(int j = i+1; j < dices.length; j++){
                int sum = dices[i] + dices[j];
                int otherSum = 0;
                for(int k=0; k < dices.length; k++){
                    if(k != i && k != j){
                        otherSum += dices[k];
                    }
                }
                combinationMap.put(sum, otherSum);
                combinationMap.put(otherSum, sum);
            }
        }

        return combinationMap;
    }
}

