package org.example;

import java.util.*;

public class Price {
    private static  final  String SHEEP="Sheep";
    private static final String AUTO="Car";
    private Map<Integer, String> doorField;
    public Price() {
    }
    public String getAUTO() {
        return AUTO;
    }
    public  Map<Integer,String> doors(){
        Random rnd= new Random();
        doorField= new HashMap<>(Map.of(1, SHEEP, 2, SHEEP, 3, SHEEP));
        doorField.replace(rnd.nextInt(1,4),AUTO);
        return doorField;
    }
    public int winKey(){
        for(Map.Entry temp:doorField.entrySet()){
            if(temp.getValue().equals(AUTO)) return (int) temp.getKey();
        }
        return -1;
    }
}

