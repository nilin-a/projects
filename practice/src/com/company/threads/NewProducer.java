package com.company.threads;

public class NewProducer implements Runnable {

    Store store;

    public NewProducer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            store.put();
        }
        System.out.println(store.getMaxAmount());
    }
}