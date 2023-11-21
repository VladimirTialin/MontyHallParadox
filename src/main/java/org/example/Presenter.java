package org.example;

import java.util.Map;
import java.util.Random;

public class Presenter {
    private static int posAuto;
    private Price price=new Price();


    public int findAuto(Map<Integer,String> doors){
        doors=price.doors();
        for (Map.Entry<Integer, String> temp : doors.entrySet()) {
            if (temp.getValue().equals(price.getAUTO())) {
                posAuto = temp.getKey();
                break;
            }
        }
        return posAuto;
    }
    public String openDoor(Map<Integer,String> doors, int door){
       return doors.get(door);
    }
    public int door(int userChoose){
        Random rnd= new Random();
        int choose;
        while (true) {
            choose = rnd.nextInt(1, 3);
            if(choose!=userChoose) return choose;
        }
    }
}
