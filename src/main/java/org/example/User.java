package org.example;

import java.util.Scanner;

public class User {
    private static String name;
    private Scanner scanner = new Scanner(System.in);

    public User() {
    }

    public int choose(int numberOfDoors, int door) {
        while (door < 1 || door > numberOfDoors) {
            System.out.print("You entered the wrong door number, try again: ");
            door = scanner.nextInt();
        }
        return door;
    }

    public String getName() {
        return name;
    }

    public boolean reply() {
        String ans=scanner.nextLine();
        while (true) {
            if (ans.equalsIgnoreCase("y")) return true;
            else if (ans.equalsIgnoreCase("n")) return false;
        }
    }
}
