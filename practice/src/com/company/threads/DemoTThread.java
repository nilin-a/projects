package com.company.threads;

public class DemoTThread extends Thread {
    public DemoTThread() {
        super("Demo R Thread");
        System.out.println("Child T thread " + this);
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child T thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child T was interrupted");
        }
        System.out.println("Exiting child T thread");
    }
}
