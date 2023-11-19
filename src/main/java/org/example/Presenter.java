package org.example;

import org.ietf.jgss.GSSContext;

public class Presenter {
    private static int posAuto;


    public void nextStep(String name){
        Gamer gamer=new Gamer(name);
        Price price=new Price();
        String [] doors=price.doors();
        for (int i = 0; i < doors.length; i++) {
            if (doors[i].equals(price.getAUTO())) {
                posAuto = i;
                break;
            }
        }
        System.out.printf("%s, хотите выбрать другую дверь?", name);
    }
}
