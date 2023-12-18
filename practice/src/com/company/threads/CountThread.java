package com.company.threads;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{
    private CommonResource commonResource;
    private Semaphore semaphore;
    private String name;
    public CountThread(CommonResource commonResource, Semaphore semaphore, String name) {
        this.commonResource = commonResource;
        this.semaphore = semaphore;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void run() {
        try {
            System.out.println(getName() + " ожидает разрешения от семафора");
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                System.out.println(getName() + ": " + commonResource.getX());
                commonResource.setX(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(getName() + " освобождает разрешение");
        semaphore.release();
    }
}
