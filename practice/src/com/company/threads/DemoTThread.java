package com.company.threads;

public class DemoTThread extends Thread {
    public DemoTThread() {
        super("Demo R Thread");
        System.out.println("Child T thread " + this);
        start();
    }

    public void run() {
        int counter = 0;
        while (!isInterrupted()) {
            System.out.println("Loop " + counter++);
        }
        System.out.println("Exiting child T thread");
    }
}
