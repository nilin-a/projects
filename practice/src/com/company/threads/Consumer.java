package com.company.threads;

public class Consumer implements Runnable{
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            queue.getN();
        }
    }
}
