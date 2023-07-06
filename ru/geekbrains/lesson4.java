package ru.geekbrains;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class lesson4 {

    static LinkedList sequence = new LinkedList();
    static ArrayDeque<String> operations = new ArrayDeque<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        boolean isProgrammWorking = true;
        while (isProgrammWorking) {
            System.out.print("Введите номер задачи или 'q' для завершения " +
                             "программы. ");
            String taskNumber = scanner.nextLine();

            switch(taskNumber) {
                case "1":
                    System.out.print("Введите количество элементов. ");
                    int size = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < size; i++) {
                        System.out.printf("Введите %d элемент. ", i + 1);
                        sequence.add(scanner.nextLine());
                    }
                    System.out.print("Список - ");
                    System.out.print(sequence);
                    System.out.println(".");

                    System.out.print("Список после переворота - ");
                    System.out.print(task1(sequence));
                    System.out.println(".");
                    break;
                case "2":
                    task2();
                case "3":
                    ArrayDeque<String> operations = task3();
                    boolean isMenuWorking = true;
                    while (isMenuWorking) {
                        int operationsSize = operations.size();
                        if (operationsSize == 0) {
                            System.out.println("Операции отсутствуют.");
                        }
                        else {
                            Iterator<String> iterator = operations.iterator();
                            System.out.println("Список операций");
                            if (operationsSize == 1) {
                                System.out.print(iterator.next());
                            } else {
                                while (iterator.hasNext()) {
                                System.out.print(iterator.next());
                                }
                            }
                        }
                        System.out.println("Введите 'd' для удаления последней операции " +
                                           "или 'q' для завершения программы");
                        String action = scanner.nextLine();

                        switch(action) {
                            case "d":
                                operations.removeLast();
                                break;
                            case "q":
                                isMenuWorking = false;
                                break;
                            default:
                                System.out.println("Вы ввели некорректный запрос.");
                                break;
                        }
                    }
                case "q":
                    isProgrammWorking = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный запрос.");
                    break;
            }
        }
    }

    public static LinkedList task1(LinkedList sequence) {
        int size = sequence.size();
        int pairs = size / 2;

        for (int i = 0, j = size - 1; i < pairs; i++, j--) {
            Collections.swap(sequence, i, j);
        }

        return sequence;
    }

    public static void task2() {
        LinkedListQueue queue = new LinkedListQueue();
        queue.add(1);
        queue.add("Информация");
        queue.add(2.5);
        queue.add('А');
        System.out.println(queue.get());
        queue.remove();
        queue.remove();
        System.out.println(queue.get());
    }

    public static ArrayDeque<String> task3() {
        boolean isProgrammWorking = true;
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
                    operations.addLast(expression);
                    break;
                case "-":
                    numbers = library.getNumbers(2, "число");
                    expression = String.format("%d - %d = %d.\n",
                                               numbers[0], numbers[1],
                                               numbers[0] - numbers[1]);
                    System.out.print(expression);
                    operations.addLast(expression);
                    break;
                case "*":
                    numbers = library.getNumbers(2, "число");
                    expression = String.format("%d * %d = %d.\n",
                                               numbers[0], numbers[1],
                                               numbers[0] * numbers[1]);
                    System.out.print(expression);
                    operations.addLast(expression);
                    break;
                case "/":
                    numbers = library.getNumbers(2, "число");
                    expression = String.format("%d / %d = %d.\n",
                                               numbers[0], numbers[1],
                                               numbers[0] / numbers[1]);
                    System.out.print(expression);
                    operations.addLast(expression);
                    break;
                case "q":
                    isProgrammWorking = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректный запрос.");
                    break;                       
            }
        }

        return operations;
    }

}
