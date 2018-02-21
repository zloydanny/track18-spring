package ru.track;

import java.util.Scanner;

/**
 *
 */
public class Sample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Type name:");
            String line = scanner.nextLine();
            if (line.equals("q")) {
                break;
            }
            System.out.println("Hello, " + line);
        }
    }
}
