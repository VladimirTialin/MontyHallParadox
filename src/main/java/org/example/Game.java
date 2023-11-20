package org.example;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private static final String[] TEXT={
            "Введите свое имя: ",
            ", хотите выбрать другую дверь ?",
            ", желаете поменять выбранную дверь? ",
            ", выберите другую дверь: "
    };
    private User user=new User();
    private Price price= new Price();
    private Presenter presenter=new Presenter();
    private Scanner scanner= new Scanner(System.in);
    private int winPosition;
    private int userChoose;
    private String name;
    private Map<Integer,String> doors;
    public void massage(String msg){
        System.out.printf(msg);
    }

    public void start() {
        massage(TEXT[0]);
        name = scanner.nextLine();
        doors = price.doors1();
        winPosition= presenter.findAuto(doors);
        System.out.printf("%s, выберите одну из %s-х дверей, за которой может находится автомобиль: ",name,doors.size());
        userChoose=user.choose(doors.size(),scanner.nextInt());
            step();

    }
    public boolean choose(){
        System.out.printf("%s%s",name,TEXT[1]);
        return user.reply();
    }
    public void step() {
        int num=presenter.door();
        boolean ans=choose();
        if (ans) {
            System.out.printf("%s%s", name, TEXT[3]);
            userChoose = user.choose(doors.size(), scanner.nextInt());
        }
        else if(doors.size()==2 && !ans){
            if(presenter.openDoor(doors, userChoose).equals(price.getAUTO())){
                System.out.println("Вы выиграли "+doors.get(userChoose));
            }
            else System.out.println("Вы проиграли, Вам выпала "+doors.get(userChoose));
        }
        else
        {
            System.out.println(
                    "\nВедущий: я открою одну из дверей, которую Вы не выбирали!\n" +
                            "Если выпадает 'ОВЦА', я позволю Вам поменять дверью.\n" +
                            "Если выпадает 'АВТОМОБИЛЬ' - Вы проиграли!\n");
            if (presenter.openDoor(doors, num).equals(price.getAUTO())) {
                System.out.println("Вы проиграли: за этой дверью находится "+presenter.openDoor(doors, num));
            }
            else {
                System.out.println("За дверью находится "+presenter.openDoor(doors, num));
                doors.remove(num);
                step();
            }
        }
    }
}
