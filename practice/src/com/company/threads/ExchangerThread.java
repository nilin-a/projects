package com.company.threads;

import java.util.concurrent.Exchanger;

public class ExchangerThread implements Runnable{
    private Exchanger<String> exchanger;
    private String message;

    private String name;

    public ExchangerThread(Exchanger<String> exchanger, String message, String name) {
        this.exchanger = exchanger;
        this.message = message;
        this.name = name;
    }

    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println(name + " received message: " + message);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
