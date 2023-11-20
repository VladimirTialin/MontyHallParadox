package org.example;

import java.util.Scanner;

public class User {
    private static String name;
    private Scanner scanner= new Scanner(System.in);

    public User(String name) {
        User.name = name;
    }

    public User() {
    }

    public int choose(int numberOfDoors, int door){
        while(door<1 || door>numberOfDoors){
            System.out.print("Вы указали не правильный номер двери,попробуйде еще раз: ");
            door=scanner.nextInt();
        }
            return door;
    }
    public boolean reply(){
        String ans=scanner.nextLine();
        while (true){
            if(ans.equalsIgnoreCase("да")) return true;
            else if (ans.equalsIgnoreCase("нет")) return false;
        }
    }
}
