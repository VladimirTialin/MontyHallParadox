package org.example;

import java.util.Map;
import java.util.Scanner;

public class Game {
    private static final String[] TEXT={
            "Enter your name: ",
            ", do you want to choose another door ? ",
            ", choose another door: "
    };
    private User user=new User();
    private Price price= new Price();
    private Presenter presenter=new Presenter();
    private Scanner scanner= new Scanner(System.in);
    private int winPosition;
    private int userChoose;
    private int rndChoose;
    private String name;
    private Map<Integer,String> doors;
    private boolean changeDoor;
    public void massage(String msg){
        System.out.printf(msg);
    }

    public void start() {
        massage(TEXT[0]);
        name = scanner.nextLine();
        doors = price.doors();
        winPosition= presenter.findAuto(doors);
        System.out.printf("%s, select one of the %s doors behind which the car can be located: ",name,doors.size());
        userChoose=user.choose(doors.size(),scanner.nextInt());
        rndChoose=presenter.door(userChoose);
        changeDoor=choose();
        if (changeDoor)
            userChoose=scanner.nextInt();
        rndChoose=presenter.door(userChoose);
        if(doors.size() == 3 && !doors.get(rndChoose).equals(price.getAUTO())) {
            System.out.printf("I open one of the doors, behind which there is %s\n",doors.get(rndChoose));
            doors.remove(rndChoose);
        }
        System.out.println(doors);
        changeDoor=choose();
        if (changeDoor) userChoose=scanner.nextInt();
        System.out.println(winPosition);
        System.out.println(userChoose);
        if(winPosition==userChoose)
            System.out.printf("You have win, behind the door is %s",doors.get(userChoose));
        else {
            System.out.printf("\n" +
                    "There is a sheep behind the %s! You've lost!",doors.get(userChoose));
        }
        System.out.println("\nEND");


    }
    public boolean choose(){
        System.out.printf("%s%s",name,TEXT[1]);
        return user.reply();
    }
}
