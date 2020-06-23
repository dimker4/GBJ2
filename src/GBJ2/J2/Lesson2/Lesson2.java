package GBJ2.J2.Lesson2;

public class Lesson2 {
    public static void main (String[] args) {
        String[][] myArr = new String[4][4];

        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[1].length; j ++) {
                myArr[i][j] = String.valueOf(i + j); // int to String
            }
        }

        myArr[1][1] = "a"; // Создаем ошибку

        try {
            System.out.println( arraySum(myArr));
        } catch (MyArraySizeException | MyArrayDataException e) { // Обрабатываем свои исключения
            e.printStackTrace();
        }
    }

    public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException // Пробросим исключения на уровень выше
    {
        final int checkArrayLength = 4;
        int sum = 0;

        if (arr.length != checkArrayLength || arr[0].length != checkArrayLength) { // Кол-во строк или столбцов
            // Выкинем исключение о размерности массива
            throw new MyArraySizeException("Размерность массива должна быть " + checkArrayLength + "х" + checkArrayLength);
        } else {
            for (int i = 0; i < arr.length; i ++) {
                for (int j = 0; j < arr.length; j ++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    }
                    // Обработаем исключение о неправильном символе и внутри него создам экземпляр своего кастомного исключения
                    catch (NumberFormatException e) {
                        throw new MyArrayDataException("Некорректный символ", i, j);
                    }
                }
            }
        }
        return sum;
    }
}


