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

    public  String getAUTO() {
        return AUTO;
    }

    public Price() {
    }

}

