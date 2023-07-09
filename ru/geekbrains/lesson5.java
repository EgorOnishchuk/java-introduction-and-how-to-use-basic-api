package ru.geekbrains;

public class lesson5 {
    
    public static void main(String[] args) {
        
        Phonebook phonebook = new Phonebook();
        PhoneNum phoneNum1 = new PhoneNum("7", "111", "1111111");
        PhoneNum phoneNum2 = new PhoneNum("7", "222", "2222222");
        PhoneNum phoneNum3 = new PhoneNum("7", "333", "3333333");
        PhoneNum phoneNum4 = new PhoneNum("7", "444", "4444444");
        phonebook.add("Иванов", phoneNum1);
        phonebook.add("Иванова", phoneNum2);
        phonebook.add("Иванов", phoneNum3);
        phonebook.add("Петров", phoneNum4);
        System.out.println(phonebook.get("Иванов"));
        System.out.println(phonebook.get("Иванова"));
        System.out.println(phonebook.get("Петров"));
    }

}
