package com.company.threads;

public class CallerThread implements Runnable{
    String message;
    CallMe target;
    Thread thread;

    public CallerThread(CallMe target, String message) {
        this.target = target;
        this.message = message;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return this.thread;
    }

    public void run() {
        synchronized (target) {
            target.call(message);
        }
    }


}

