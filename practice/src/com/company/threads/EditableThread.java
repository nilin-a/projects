package com.company.threads;

public class EditableThread implements Runnable {
    private String name;
    private Thread thread;
    private boolean suspendedFlag;

    public EditableThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("New thread is " + thread);
        suspendedFlag = false;
        thread.start();
    }
    public Thread getThread() {
        return this.thread;
    }
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread " + thread.getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendedFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " was interrupted");
        }
        System.out.println(thread.getName() + " exiting");
    }

    public void mySuspend() {
        suspendedFlag = true;
    }

    public synchronized void myResume() {
        suspendedFlag = false;
        notify();
    }
}
