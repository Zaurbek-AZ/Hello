package lesson_five;

public class ThreadTest extends Thread{

    private final float[] ar;
    private int offset;

    public ThreadTest(float[] ar, int offset) {
        this.ar = ar;
        this.offset = offset;
        start();
    }

    @Override
    public void run() {
        System.out.println(getName() + "start");
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (float)(ar[i] * Math.sin(0.2f + i + offset /5) * Math.cos(0.2f + i + offset /5) * Math.cos(0.4f + i + offset / 2));
        }
        System.out.println(getName() + "stop");
    }
}
