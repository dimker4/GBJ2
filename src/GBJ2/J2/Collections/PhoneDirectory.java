package GBJ2.J2.Collections;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private HashMap<String, ArrayList<String>> phoneBook; // Ключ - фамилия, Значение - Массив Номеров телефона в формате +7...

    PhoneDirectory () { // Внутри конструктора инициализируем мапу
        phoneBook = new HashMap<>();
    }

    public void add(String key, String value) {
        if (phoneBook.containsKey(key)) { // Если номер по такому ключу уже есть, то добавим еще 1 номер в имеющийся ArrayList
            ArrayList<String> numbers = phoneBook.get(key);
            numbers.add(value);
            this.phoneBook.put(key, numbers);
            return;
        }

        ArrayList<String> numbers = new ArrayList<>(); // Если номера нет, то добавим его в новом массиве
        numbers.add(value);
        this.phoneBook.put(key, numbers);
    }

    public String get(String key) { // Ищем по ключу значение в мапе
        ArrayList<String> result = new ArrayList<>();
        result = phoneBook.get(key); // Получаю значение по ключу и возвращаю его в виде строки

        return key + " | " + result.toString();
    }
}
