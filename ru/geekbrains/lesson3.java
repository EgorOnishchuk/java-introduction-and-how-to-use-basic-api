package ru.geekbrains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    static ArrayList<Integer> numbers = new ArrayList<>();
    static Iterator<Integer> iterator = null;
    static ArrayList result = new ArrayList();
    static Scanner scanner = new Scanner(System.in);
    static Random randomNum = new Random();
    
    public static void main(String[] args) {
        
        System.out.print("Введите количество чисел. ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите минимальное число для диапазона чисел в " +
                         "списке. ");
        int minNum = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите максимальное число для диапазона чисел в " +
                         "списке. ");
        int maxNum = Integer.parseInt(scanner.nextLine()) + 1;
        for (int i = 0; i < size; i++) {
            numbers.add(randomNum.nextInt(minNum, maxNum));
        }
        System.out.print("Список - ");
        System.out.print(numbers);
        System.out.println(".");

        result = task(numbers);
        Object object = result.get(0);
        ArrayList changedList = (ArrayList)object;
        System.out.print("Список после удаления чётных чисел - ");
        System.out.print(changedList);

        System.out.printf(", максимальное число - %d, минимальное " +
                          "число - %d, среднее арифметическое - %d.",
                          result.get(1), result.get(2),
                          result.get(3));
        
    }

    static ArrayList task(ArrayList<Integer> numbers) {
        int minNum = numbers.get(0);
        for (int i: numbers) {
            if (i < minNum) {
                minNum = i;
            }
        }

        int maxNum = numbers.get(0);
        for (int i: numbers) {
            if (i > maxNum) {
                maxNum = i;
            }
        }

        int arithmeticalAverage = 0;
        int size = numbers.size();
        for (int i: numbers) {
            arithmeticalAverage += i;
        }
        arithmeticalAverage /= size;

        iterator = numbers.iterator();
        while(iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        ArrayList result = new ArrayList(List.of(numbers, maxNum, minNum, arithmeticalAverage));
        return result;

    }

}
