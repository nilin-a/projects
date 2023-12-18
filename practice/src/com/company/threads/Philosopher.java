package com.company.threads;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    private Semaphore semaphore;
    private int number = 0;
    private int id;

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            while (number < 3) {
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                sleep(1000);
                number++;
                System.out.println("Философ " + id + " выходит из-за стола");
                semaphore.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
