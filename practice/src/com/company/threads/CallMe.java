package com.company.threads;

public class CallMe {
    void call(String message) {
        System.out.println("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Call me was interrupted");
        }
        System.out.println("]");
    }
}
