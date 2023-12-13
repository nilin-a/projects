package com.company.threads;

public class DemoRThread implements Runnable{
    Thread demoThread;

    public DemoRThread() {
        demoThread = new Thread(this, "Demo R Thread");
        System.out.println("Child R thread " + demoThread);
        demoThread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child R thread: " + i);
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            System.out.println("Child R was interrupted");
        }
        System.out.println("Exiting child R thread");
    }
}
