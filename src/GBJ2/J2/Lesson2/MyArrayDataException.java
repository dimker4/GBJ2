package GBJ2.J2.Lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int i, int j)
    {
        super(message + " в ячейке [" + i + ", " + j + "]" );
    }
}
