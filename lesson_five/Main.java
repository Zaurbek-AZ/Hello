package lesson_five;

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static final float[] arrOne = new float[SIZE];
    private static final float[] arrTwo = new float[SIZE];

    public static void main(String[] args) {

        Arrays.fill(arrOne, 1f);
        Arrays.fill(arrTwo, 1f);

        long a = System.currentTimeMillis();
        calcOperation(arrOne);
        long deltaA = System.currentTimeMillis() - a;
        System.out.println("methodOne " + deltaA + " ms");

        a = System.currentTimeMillis();
        calcWithThreads(arrTwo);
        long deltaB= System.currentTimeMillis() - a;
        System.out.println("methodTwo " + deltaB + " ms");
    }

    private static void calcOperation(float ar[]){
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (float)(ar[i] * Math.sin(0.2f + i /5) * Math.cos(0.2f + i /5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void calcWithThreads(float ar[]){

        final float[] a1 =  new float[HALF];
        final float[] a2 =  new float[HALF];


        System.arraycopy(ar,0,a1,0,HALF);
        System.arraycopy(ar,HALF,a2,0,HALF);

        ThreadTest threadTestOne = new ThreadTest(ar,0);
        ThreadTest threadTestTwo = new ThreadTest(ar,HALF);

        try {
            threadTestOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            threadTestTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(a1,0,ar,0,HALF);
        System.arraycopy(a2,0,ar,HALF,HALF);

        System.out.println(arrOne.equals(arrTwo)); // показывает ложь
    }

}
