package com.example.demo.service;

import com.example.demo.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GameService {
    public Game makeGame(){
        List<Player> playerList = new ArrayList<Player>();
        for(Color color: Color.values()){
            int id = (int)(Math.random()*100000);
            playerList.add(new Player(id, color));
        }
        return new Game(playerList);
    }

    public Map<Integer, Integer> roleDice(){
        int dice1 = Dice.role();
        int dice2 = Dice.role();
        int dice3 = Dice.role();
        int dice4 = Dice.role();
        int[] dices = {dice1, dice2, dice3, dice4};

        return Dice.getCombination(dices);
    }

    public Map<Integer, Integer> getHikeAble(Map<Integer,Integer> hikingStick, Map<Integer,Integer> combination, Set<Integer> done){
        Map<Integer, Integer> hikeAble = new HashMap<Integer, Integer>();
        for(int route: combination.keySet()){
            int otherRoute = combination.get(route);
            if(done.contains(route)){
                if(!done.contains(otherRoute)){
                    hikeAble.put(otherRoute, 0);
                }
            } else {
                if(done.contains(otherRoute)){
                    hikeAble.put(route,0);
                } else {
                    hikeAble.put(route, otherRoute);
                    hikeAble.put(otherRoute, route);
                }
            }
        }

        if(hikingStick.size() == 3){
            for(int route: hikeAble.keySet()){
                if(!hikingStick.keySet().contains(route)){
                    hikeAble.remove(route);
                }
            }
        } else if(hikingStick.size() == 2){
            for(int route: hikeAble.keySet()){
                if(!hikingStick.keySet().contains(route) && !hikingStick.keySet().contains(hikeAble.get(route))){
                    hikeAble.put(route, 0);
                }
            }
        }

        return hikeAble;
    }

    public HikingStick hike(Player player, Set<Integer> hikeRoute){
        HikingStick hikingStick = Optional.ofNullable(player.getHikingStick()).orElse(new HikingStick());
        for(int route: hikeRoute){
            int basecamp = player.getBasecamp().getHeight(route);
            if(!hikingStick.getRouteHeight().containsKey(route) && basecamp != 0){
                hikingStick.setHikingStickOnBasecamp(route, basecamp);
            }
            hikingStick.hikingOneHeight(route);
        }
        return hikingStick;
    }

    public void removeHikingStick(Player player){
        player.setHikingStick(null);
    }

    public Basecamp buildBasecamp(Player player){
//        Basecamp basecamp = player.getBasecamp();
//        for(int route: player.getHikingStick().getRouteHeight().keySet()){
//            basecamp.getHeight()
//        }
        player.getBasecamp().setBasecamp(player.getHikingStick().getRouteHeight());
        return player.getBasecamp();
    }

    public void removeBasecamp(Game game, int route){
        for(Player player: game.getPlayerList()){
            player.getBasecamp().destroyBasecamp(route);
        }
    }
}
