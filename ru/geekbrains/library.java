package ru.geekbrains;

import java.util.Scanner;

public class library {

    static Scanner scanner = new Scanner(System.in);

    public static int[] getValues(int number, String element) {
        int[] result = new int[number];

        for (int i = 1; i <= number; i++) {
            System.out.printf("Введите %d %s. ", i, element);
            result[i - 1] = Integer.parseInt(scanner.nextLine());
        }
        
        return result;
    }

}
