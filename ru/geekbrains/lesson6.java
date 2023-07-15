package ru.geekbrains;

import java.util.HashSet;

public class lesson6 {

    static HashSet<Cat> cats = new HashSet<>();
    
    public static void main(String[] args) {
        
        Cat cat1 = new Cat("Барсик", "Американская короткошёрстная", 1, 4);
        Cat cat2 = new Cat("Рыжик", "Абиссинская", 1, 5);
        Cat cat3 = new Cat("Буся", "Ангорская", 0, 8);
        Cat cat4 = new Cat("Пушок", "Манчкин", 1, 2);
        Cat cat5 = new Cat("Рыжик", "Абиссинская", 1, 5);

        if (cat1.equals(cat4)) {
            System.out.println("Кошки равны.");
        }
        else {
            System.out.println("Кошки не равны.");
        }

        if (cat2.equals(cat5)) {
            System.out.println("Кошки равны.");
        }
        else {
            System.out.println("Кошки не равны");
        }

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        System.out.printf("Уникальные кошки - %s.", cats);

    }

}
