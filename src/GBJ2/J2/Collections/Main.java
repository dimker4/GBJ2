package GBJ2.J2.Collections;

import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        // Задание 1
        wordsArray();

        // Задание 2
        PhoneDirectory pd = new PhoneDirectory();
        pd.add("John", "+79120000000"); // Добавим запись в справочник
        pd.add("Ivan", "+79120000001");
        pd.add("Ivan", "+79120000010");
        pd.add("Ivan", "+79120000015");
        pd.add("Stan", "+79120000002");
        pd.add("Petr", "+79120000003");

        System.out.println(pd.get("Ivan")); // Получим запись и сразу выведем
    }

    public static void wordsArray () {
        String text = "Lorem ipsum dolor sit amet, sem consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. " +
                "Dis ligula parturient montes, nascetur ridiculus mus sem"; // Возьмем случайный текст

        String[] textArr = text.split(" "); // Получаем массив слов из текста, разобъем по пробелу
        HashMap<String, Integer> hm = new HashMap<>(); // Создаем ассоциативный массив String - key, Integer - Value
        int value = 0;

        for (String word: textArr) {
            if (hm.containsKey(word)) { // Если в мапе есть поле с таким ключем, то увеличиваем
                value = hm.get(word);
                hm.put(word, ++value);
            } else { // Если нет, то кладем  1
                hm.put(word, 1);
            }
        }

        System.out.println("Количество уникальных слов: " + hm.size()); // размер мапы, так как ключи уникальные

        for(String key : hm.keySet()) { // Ключ - слово, Значение - количество повторений
            System.out.println("Слово: " + key + " Количество: " + hm.get(key));
        }
    }
}
