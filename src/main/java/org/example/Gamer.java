package org.example;

import java.util.Scanner;

public class Gamer {
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Gamer.name = name;
    }

    public Gamer(String name) {
        Gamer.name = name;
    }
    public int choose(int numberOfDoors,int door){
        Scanner scanner= new Scanner(System.in);
        while(door<1 || door>numberOfDoors){
            System.out.print("Вы указали не правильный номер двери,попробуйде еще раз: ");
            door=scanner.nextInt();
        }
            return door;
    }
    public boolean reply(){
        Scanner ans =new Scanner(System.in);
        while (true){
            if(ans.nextLine().equalsIgnoreCase("да")) return true;
            else if (ans.nextLine().equalsIgnoreCase("нет")) return false;
        }
    }
}
