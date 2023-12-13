package com.company.threads;

public class Producer implements Runnable{
    Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            queue.setN(i++);
        }
    }
}
