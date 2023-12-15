package com.company.threads;

public class Store {
    private int product = 0;
    private int maxAmount = 0;

    public int getMaxAmount(){
        return this.maxAmount;
    }
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар. Товаров на складе: " + product);
        //System.out.printf("Покупатель купил %d товаров\n", product);
        //product = 0;
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        maxAmount++;
        System.out.println("Производитель добавил 1 товар. Товаров на складе: " + product);
        notify();
    }
}
