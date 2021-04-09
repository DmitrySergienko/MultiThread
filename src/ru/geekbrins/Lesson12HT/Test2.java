package ru.geekbrins.Lesson12HT;

import java.util.Arrays;


public class Test2 implements Runnable{
    private String name;


    public Test2(String name) {
        this.name = name;
    }

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    @Override
    public void run() {
        float[] a1 = new float[10_000_000];
        float[] a2 = new float[10_000_000];
        float[] arr = new float[SIZE];

//первый массив в работе
        System.arraycopy(arr,0,a1,0,SIZE);
        Arrays.fill(a1,1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(name + "Второй метод (массив а1) время исполнения : " + Thread.currentThread().getName() + " " + (System.currentTimeMillis() - a));

//второй массив в работе
        System.arraycopy(arr,0,a2,0,SIZE);
        Arrays.fill(a1,1);
        long b = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

//склеиваю массив
        System.arraycopy(a1,0,arr,0,SIZE);
        System.arraycopy(a2,0,arr,0,SIZE);
        System.currentTimeMillis();
        System.out.println(name + "Второй метод (массив а2) время исполнения : " + Thread.currentThread().getName() + " " + (System.currentTimeMillis() - b));
    }
}

