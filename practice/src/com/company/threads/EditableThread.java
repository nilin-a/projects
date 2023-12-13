package com.company.threads;

public class EditableThread implements Runnable {
    String name;
    private Thread thread;

    public Thread getThread() {
        return this.thread;
    }

    public EditableThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New thread is " + thread);
        thread.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread " + thread.getName() + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " was interrupted");
        }
        System.out.println(thread.getName() + " exiting");
    }
}
