package ru.geekbrains;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    
    static StringBuilder result;
    static HashMap<String, ArrayList<PhoneNum>> hashMap;

    public Phonebook() {
        hashMap = new HashMap<String, ArrayList<PhoneNum>>();
    }

    public void add(String surname, PhoneNum phoneNum) {
        if (hashMap.containsKey(surname)) {
            hashMap.get(surname).add(phoneNum);
        }
        else {
            ArrayList<PhoneNum> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            hashMap.put(surname, phoneNumbers);
        }
    }

    public String get(String surname) {
        if (hashMap.containsKey(surname)) {
            result = new StringBuilder();
            int size = hashMap.get(surname).size();

            for (int i = 0; i < size ; i++) {
                if (i + 1 == size) {
                    result.append(String.format("%s.", 
                                  hashMap.get(surname).get(i).toString()));
                }
                else {
                    result.append(String.format("%s, ",
                                  hashMap.get(surname).get(i).toString()));
                }
            }
        }
        else {
            throw new RuntimeException("Номер не найден.");
        }

        return result.toString();
    }

}
