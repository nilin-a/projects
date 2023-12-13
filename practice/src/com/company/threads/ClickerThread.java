package com.company.threads;

public class ClickerThread implements Runnable {
    private long click = 0;
    private Thread thread;
    private volatile boolean running = true;

    public ClickerThread(int priority) {
        thread = new Thread(this);
        thread.setPriority(priority);
    }

    public Thread getThread() {
        return this.thread;
    }

    public long getClick() {
        return this.click;
    }

    public void run() {
        while (running) {
            click++;
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        thread.start();
    }
}
