package org.example;

import java.util.Scanner;

public class Constructor {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String name = scanner.nextLine();
        Gamer gamer = new Gamer(name);
        Price price = new Price();
        Presenter presenter=new Presenter();
        String[] doors = price.doors();
        System.out.printf("Выберите одну из %s-х дверей, за которой может находится автомобиль: ",doors.length);
        int numberDoor=gamer.choose(doors.length,scanner.nextInt());
        presenter.nextStep(name);
        boolean ans=gamer.reply();
        if(ans) numberDoor=gamer.choose(doors.length,scanner.nextInt());

//        if(doors[numberDoor].equals(price.getAUTO())) System.out.println("Вы выиграли автомобиль");
//        else
//

    }
}
