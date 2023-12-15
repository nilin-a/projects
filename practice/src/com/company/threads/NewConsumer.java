package com.company.threads;

public class NewConsumer implements Runnable{
    Store store;
    public NewConsumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i <= 20; i++) {
            store.get();
        }
    }
}
