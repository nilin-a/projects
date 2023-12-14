package com.company.threads;

public class MetaRThread implements Runnable{
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Loop " + counter++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
