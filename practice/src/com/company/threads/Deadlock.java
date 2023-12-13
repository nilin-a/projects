package com.company.threads;

public class Deadlock implements Runnable{
    A a = new A();
    B b = new B();

    public Deadlock() {
        Thread.currentThread().setName("Deadlock thread");
        Thread thread = new Thread(this, "Racing Thread");
        thread.start();
        a.foo(b);
        System.out.println("Back in deadlock thread");
    }

    public void run() {
        b.bar(a);
        System.out.println("Back in the other thread");
    }
}
