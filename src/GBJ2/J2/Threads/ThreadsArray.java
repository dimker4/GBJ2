package GBJ2.J2.Threads;

public class ThreadsArray extends Thread {
    final private float[] arr;
    private int start; // Стартовое значение для i
    private int end;   // Конечное значение для i

    ThreadsArray (float[] a, int start, int end) {
        this.arr = a;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int j = 0;
        for (int i = this.start; i < this.end; i ++) {
            j++;
            arr[j] = (float)(arr[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
