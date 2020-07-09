package GBJ2.J2.Threads;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        simpleMathArray();
        threadsMathArray();
    }

    public static void simpleMathArray() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        long time = 0;

        Arrays.fill(arr, 1); // заполним весь массив единицами
        time = System.currentTimeMillis(); // Получаем время до начала расчета

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("1 thread: " + (System.currentTimeMillis() - time)); // Получаем время работы ~1450
    }

    public static void threadsMathArray () {
        final int size = 10000000; // Длина исходного массива
        final int countThreads = 4; // Количество потоков, в которых будем считать массив
        final int h = size / countThreads; // Длина одного массива
        float[] arrSource = new float[size]; // Исходный массив
        Thread[] t = new Thread[countThreads]; // Массив с объектами класса для обработки исходного массива
        long time = 0;
        int start = 0; // Переменная для корректного разбиения исходного массива на части
        ArrayList<float[]> arrList = new ArrayList(); // Массив с кусками исходного массива, для удобства склеивания

        Arrays.fill(arrSource, 1); // заполним весь массив единицами
        time = System.currentTimeMillis(); // Получаем время до начала расчета

        for (int i = 0; i < countThreads; i ++) { // создаем 1 поток за итерацию и запускаем на выполнение
            arrList.add(i, new float[h]);

            System.arraycopy(arrSource, start, arrList.get(i), 0, h); // Копируем часть исходного массива
            t[i] = new ThreadsArray(arrList.get(i), i * h, i * h + h-1); // Создаем экземпляр внутри массива
            t[i].start(); // запускаем поток на выполнение
            start = start + h;
        }

        for (int i = 0; i < countThreads; i ++) {
            try {
                t[i].join(); // После запуска, ожидаем завершения потока
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        start = 0;

        for (float[] a: arrList) { // Склеиваем все массивы в один
            System.arraycopy(a, 0, arrSource, start, h);
            start += h;
        }

        System.out.println(countThreads + " threads: " + (System.currentTimeMillis() - time)); // Получаем время работы

    }
}
