package ru.geekbrins.Lesson12HT;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Thread fistMethod = new Thread(new Test("Скрость обработки первого метода потоком: "));
        fistMethod.start();
        //Thread secondMethod = new Thread(new Test2("Скрость обработки второго метода потоком: "));
        //secondMethod.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Test2("Excecutor!!!"));
        executorService.shutdown();

    }
}
class Test implements Runnable{

    private String name;

    public Test(String name) {
        this.name = name;
    }

    static final int size = 10_000_000;
    //static final int HALF = size / 2;

    @Override
    public void run() {
        float[] arr = new float[size];
        Arrays.fill(arr,1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println(name + Thread.currentThread().getName() + " " + (System.currentTimeMillis() - a));
    }
}
