package ru.geekbrains;

import java.util.Scanner;

public class lesson1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isProgrammWorking = true;
        while (isProgrammWorking) {
            System.out.print("Введите номер задачи или 'q' для завершения " +
                    "программы. ");
            String taskNumber = scanner.nextLine();

            switch (taskNumber) {
                case "1":
                    System.out.print("Введите число. ");
                    int number = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Сумма - %d, факториал - %d.\n", task1(number)[0], task1(number)[1]);
                    break;
                case "2":
                    int[] result = task2();
                    int length = result.length;
                    System.out.printf("Числа - ");
                    for (int i = 0; i < length; i++) {
                        System.out.printf("%d ", result[i]);
                    }
                    System.out.println();
                    break;
                case "3":
                    task3();
                    break;
                case "q":
                    isProgrammWorking = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный запрос.");
                    break;
            }
        }
    }

    static int[] task1(int number) {
        int summary = 0;
        for (int i = 1; i <= number; i++) {
            summary += i;
        }

        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        int[] result = {summary, factorial};
        return result;
    }

    static int[] task2() {
        final int PRIME_NUMBERS_FROM_1_TO_1000 = 168;
        int[] result = new int[PRIME_NUMBERS_FROM_1_TO_1000];
        result[0] = 2;
        int index = 1;
        boolean isPrime = true;

        for (int i = 3; i <= 1000; i += 2) {
            isPrime = true;
            for (int j = 3; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    static void task3() {
        boolean isProgrammWorking = true;
        while (isProgrammWorking) {
            System.out.print("Введите арифметическую операцию - '+' для " +
                    "сложения, '-' для вычитания, '*' для " +
                    "умножения, '/' для деления, или 'q' для " +
                    "завершения программы. ");
            String operation = scanner.nextLine();

            int[] numbers;
            switch (operation) {
                case "+":
                    numbers = library.getNumbers(2, "число");
                    System.out.printf("%d + %d = %d.\n", numbers[0],
                            numbers[1], numbers[0] + numbers[1]);
                    break;
                case "-":
                    numbers = library.getNumbers(2, "число");
                    System.out.printf("%d - %d = %d.\n", numbers[0],
                            numbers[1], numbers[0] - numbers[1]);
                    break;
                case "*":
                    numbers = library.getNumbers(2, "число");
                    System.out.printf("%d * %d = %d.\n", numbers[0],
                            numbers[1], numbers[0] * numbers[1]);
                    break;
                case "/":
                    numbers = library.getNumbers(2, "число");
                    System.out.printf("%d / %d = %d.\n", numbers[0],
                            numbers[1], numbers[0] / numbers[1]);
                    break;
                case "q":
                    isProgrammWorking = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный запрос.");
                    break;
            }
        }
    }
}
