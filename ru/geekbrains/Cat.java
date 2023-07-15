package ru.geekbrains;

import java.util.Objects;

/**
 * Кошка, имеющая имя, породу, пол и возраст.
 */
public class Cat {

    /**
     * Кличка кошки.
     */
    public String name;

    /** 
     * Порода кошки.
     */ 
    public String breed;

    /**
     * Пол кошки.
     */
    private String sex;

    /** 
     * Возраст кошки.
     */ 
    private int age;

    public Cat(String name, String breed, int sex, int age) {
        this.name = name;
        this.breed = breed;

        if (sex == 1) {
            this.sex = "кот";
        }
        else if (sex == 0) {
            this.sex = "кошка";
        }
        else {
            throw new RuntimeException("Пол указан некорректно.");
        }

        if (age >= 1) {
            this.age = age;
        }
        else {
            throw new RuntimeException("Возраст указан некорректно.");
        }
    }

    /**
     * Возвращает пол кошки.
     */ 
    public String getSex() {
        return sex;
    }

    /**
     * Устанавливает пол кошки.
     */ 
    public void setSex(int sex) {
        if (sex == 1) {
            this.sex = "кот";
        }
        else if (sex == 0) {
            this.sex = "кошка";
        }
        else {
            throw new RuntimeException("Пол указан некорректно.");
        }
    }

    /**
     * Возвращает возраст кошки.
     */ 
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст кошки.
     */
    public void setAge(int age) {
        if (age >= 1) {
            this.age = age;
        }
        else {
            throw new RuntimeException("Возраст указан некорректно.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Cat cat = (Cat) object;
        return name == cat.name && breed == cat.breed && sex == cat.sex &&
               age == cat.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, sex, age);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", name, breed, sex, age);
    }

}
