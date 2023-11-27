package org.example;
import java.util.Random;

public class Presenter {
    public int door(int userChoose,int [] key){
        Random rnd= new Random();
        int choose;
        while (true) {
            choose = key[rnd.nextInt(key.length)];
            if(choose!=userChoose) return choose;
        }
    }
}
