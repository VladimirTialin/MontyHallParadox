package org.example;

import java.util.*;

public class Price {
    private static  String SHEEP="Овца";
    private static  String AUTO="Автомобиль";
    public  String [] doors(){
        Random rnd= new Random();
        String [] door= new String[3];
        door[rnd.nextInt(door.length)]=AUTO;
        for (int i = 0; i < door.length; i++) {
            if(door[i]==null) door[i]=SHEEP;
        }
        return door;
    }
    public  Map<Integer,String> doors1(){
        Random rnd= new Random();
        Map<Integer,String> door=new HashMap<>(Map.of(1,SHEEP,2,SHEEP,3,SHEEP));
        door.replace(rnd.nextInt(1,3),AUTO);
        return door;
    }

    public  String getAUTO() {
        return AUTO;
    }

    public Price() {
    }


}

