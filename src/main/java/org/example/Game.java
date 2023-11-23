package org.example;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private static final String[] TEXT = {
            "Enter your name: ",
            ", do you want to choose another door ? ",
            "Choose another door: ",
            "You WIN!",
            "I open one of the doors, behind which there is "
    };
    private final User user = new User();
    private final Price price = new Price();
    private final Presenter presenter = new Presenter();
    private final Scanner scanner = new Scanner(System.in);
    private int winPosition,userChoose,presenterChoose;
    private String name;
    private Map<Integer, String> doors;
    private boolean changeDoor,testWin; //<- для тестов
    private static final Random test=new Random();// только для тестов
    public void start() {
        System.out.print(TEXT[0]);
//        name = scanner.nextLine();
        name = "Tester";
        doors = price.doors();
        winPosition = price.winKey();
        System.out.printf("%s, select one of the %s doors behind which the car can be located: ", name, doors.size());
        playerNumberTest();
        changeDoor = chooseTest();
        System.out.println(winPosition);
        System.out.println(presenterChoose);
        if (changeDoor) {
            System.out.print(TEXT[2]);
            playerNumberTest();
            firstRound();
        } else firstRound();
    }
    public boolean choose() {
        System.out.printf("%s%s", name, TEXT[1]);
        return user.reply();
    }
    private void firstRound() {
        if (presenterChoose == winPosition){
            System.out.printf("There is a %s behind the door, you have lost!",doors.get(winPosition));
        }
        else if(winPosition==userChoose){
            testWin=true;
            System.out.println(TEXT[3]);
        }
        else if(userChoose==presenterChoose){
            System.out.printf(TEXT[4]+"%s\n", doors.get(presenterChoose));
            finalRound();

        finalRound();}
        else {
            System.out.printf(TEXT[4]+"%s\n", doors.get(presenterChoose));
            doors.remove(presenterChoose);
            finalRound();
        }
    }
    private void playerNumber() {
        userChoose = user.choose(doors.size(), scanner.nextInt());
        presenterChoose = presenter.door(userChoose);
    }
    private void finalRound(){
        changeDoor=chooseTest();
        if(changeDoor) playerNumberTest();
        if(doors.get(userChoose).equals(price.getAUTO())){
            testWin=true;
            System.out.println(TEXT[3]);}
        else
            System.out.printf("There is a %s behind the door, you have lost!",doors.get(winPosition));
        }
//Методы только для тестов!!!!!!!
    public boolean chooseTest(){
        return test.nextBoolean();
    }
    private void playerNumberTest() {
        if(doors.size()==2) {
            while (true) {
                userChoose = test.nextInt(1, 3);
                for (Map.Entry t : doors.entrySet()) {
                    if (t.getKey().equals(userChoose)) {
                        userChoose = (int) t.getKey();
                        break;
                    }
                }
            }
        }
        else userChoose = test.nextInt(1, 3);
        presenterChoose = presenter.door(userChoose);
    }

    public boolean isTestWin() {
        return testWin;
    }
}
