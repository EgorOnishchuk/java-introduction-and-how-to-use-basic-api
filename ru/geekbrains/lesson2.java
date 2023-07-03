package ru.geekbrains;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class lesson2 {

    static Scanner scanner = new Scanner(System.in);
    static File file = null;
    static FileWriter fileWriter = null;

    public static void main(String[] args) {

        boolean isProgrammWorking = true;
        while (isProgrammWorking) {
            System.out.print("Введите номер задачи или 'q' для завершения " +
                             "программы. ");
            String taskNumber = scanner.nextLine();

            switch (taskNumber) {
                case "1":
                    System.out.printf("Введите количество пар 'ключ - значение'. ");
                    int pairs = Integer.parseInt(scanner.nextLine());
                    String[] keys = library.getStrings(pairs, "ключ");
                    String[] values = library.getStrings(pairs, "значение");
                    System.out.println(task1("students", "*", keys, values));
                    break;
                case "2":
                    System.out.print("Введите длину. ");
                    int number = Integer.parseInt(scanner.nextLine());
                    int[] array = library.getNumbers(number, "число");
                    System.out.print("Отсортированный массив - ");
                    System.out.print(Arrays.toString(task2(array)));
                    System.out.println(".");
                    break;
                case "4":
                    task4();
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

    static String task1(String table, String attribute, String[] keys, 
                        String[] values) {
        String string = String.format("SELECT %s FROM %s WHERE ", attribute,
                                      table);
        StringBuilder query = new StringBuilder(string);
        int length = keys.length;

        for (int i = 0; i < length; i++) {
            if (!values[i].equals("null")) {
                query
                    .append(keys[i])
                    .append(" = ")
                    .append(values[i]);
            }
            if (i + 1 != length && !values[i + 1].equals("null")) {
                query.append(" AND ");
            }       
        }

        query.append(";");
        return query.toString();
    }

    static int[] task2(int[] array) {
        try {
            int length = array.length;
            file = new File("ru\\geekbrains\\task_2_log.txt");
            fileWriter = new FileWriter(file, true);

            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (array[j + 1] < array[j]) {
                        int temporary = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temporary;
                    }
                }
                for (int j : array) {
                    fileWriter.append(Integer.toString(j) + " ");
                }
                fileWriter.append("\n");
                fileWriter.flush();
            }

            fileWriter.close();
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при работе с файлами.");
        }

        return array;
    }

    static void task4() {
        boolean isProgrammWorking = true;
        try {
            file = new File("ru\\geekbrains\\task_4_log.txt");
            fileWriter = new FileWriter(file, true);
            while (isProgrammWorking) {
                System.out.print("Введите арифметическую операцию - '+' для " +
                                 "сложения, '-' для вычитания, '*' для " +
                                 "умножения, '/' для деления, или 'q' для " +
                                 "завершения программы. ");
                String operation = scanner.nextLine();

                int[] numbers;
                String expression;
                switch (operation) {
                    case "+":
                        numbers = library.getNumbers(2, "число");
                        expression = String.format("%d + %d = %d.\n",
                                                   numbers[0], numbers[1],
                                                   numbers[0] + numbers[1]);
                        System.out.print(expression);
                        fileWriter.append(expression);
                        fileWriter.flush();
                        break;
                    case "-":
                        numbers = library.getNumbers(2, "число");
                        expression = String.format("%d - %d = %d.\n",
                                                   numbers[0], numbers[1],
                                                   numbers[0] - numbers[1]);
                        System.out.print(expression);
                        fileWriter.append(expression);
                        fileWriter.flush();
                        break;
                    case "*":
                        numbers = library.getNumbers(2, "число");
                        expression = String.format("%d * %d = %d.\n",
                                                   numbers[0], numbers[1],
                                                   numbers[0] * numbers[1]);
                        System.out.print(expression);
                        fileWriter.append(expression);
                        fileWriter.flush();
                        break;
                    case "/":
                        numbers = library.getNumbers(2, "число");
                        expression = String.format("%d / %d = %d.\n",
                                                   numbers[0], numbers[1],
                                                   numbers[0] / numbers[1]);
                        System.out.print(expression);
                        fileWriter.append(expression);
                        fileWriter.flush();
                        break;
                    case "q":
                        isProgrammWorking = false;
                        fileWriter.append("Программа завершена.\n");
                        fileWriter.flush();
                        break;
                    default:
                        System.out.println("Вы ввели некорректный запрос.");
                        fileWriter.append("Введён некорректный запрос.\n");
                        fileWriter.flush();
                        break;
                }
            }

            fileWriter.close();
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при работе с файлами.");
        }
    }
}
