package org.example;

import java.util.*;
public class Price {
    private static final String AUTO = "Car";
    private static final Map<Integer, String> doorField = new HashMap<>(Map.of(1, "Sheep",
            2, "Sheep",
            3, "Sheep"));
    public Price() {
    }
    public String getAUTO() {
        return AUTO;
    }
    public Map<Integer, String> doors() {
        Random rnd = new Random();
        doorField.replace(rnd.nextInt(1, 4), AUTO);
        return doorField;
    }
    public int winKey() {
        for (Map.Entry temp : doorField.entrySet()) {
            if (temp.getValue().equals(AUTO)) return (int) temp.getKey();
        }
        return -1;
    }
    public int[] keys(){
        int index=0;
        int [] value = new int[doorField.size()];
        for (Map.Entry key : doorField.entrySet()) {
            value[index]=(int) key.getKey();
            index++;
        }
        return value;
    }
}

