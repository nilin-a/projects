package com.company.threads;

public class Queue {
    private int n;
    private boolean valueSet = false;

    synchronized void getN() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        n = 0;
        valueSet = false;
        notify();
    }

    synchronized void setN(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        n++;
        valueSet = true;
        System.out.println("Set: " + n);
        notify();
    }
}
