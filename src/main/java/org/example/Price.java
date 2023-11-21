package org.example;

import java.util.*;

public class Price {
    private static  String SHEEP="Sheep";
    private static  String AUTO="Car";

    public  Map<Integer,String> doors(){
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

