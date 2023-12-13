package com.company;

import com.company.threads.*;
import jdk.jfr.StackTrace;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);

        /*
        CallMe target = new CallMe();
        CallerThread callerThread1 = new CallerThread(target, "Hello");
        CallerThread callerThread3 = new CallerThread(target, "World");
        CallerThread callerThread2 = new CallerThread(target, "Synchronized");


        try {
            callerThread1.getThread().join();
            callerThread2.getThread().join();
            callerThread3.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted");
        }
         */

        /*
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        ClickerThread hi = new ClickerThread(Thread.NORM_PRIORITY + 2);
        ClickerThread lo = new ClickerThread(Thread.NORM_PRIORITY - 2);

        lo.start();
        hi.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        lo.stop();
        hi.stop();

        try {
            hi.getThread().join();
            lo.getThread().join();
        } catch (InterruptedException e ) {
            System.out.println(e);
        }

        System.out.println("Low-priority thread: " + lo.getClick());
        System.out.println("High-priority thread: " + hi.getClick());
         */

        /*
        EditableThread t1 = new EditableThread("One");
        EditableThread t2 = new EditableThread("Two");
        EditableThread t3 = new EditableThread("Three");

        System.out.println(t1.getThread().getName() + " thread is alive: " + t1.getThread().isAlive());
        System.out.println(t2.getThread().getName() + " thread is alive: " + t2.getThread().isAlive());
        System.out.println(t3.getThread().getName() + " thread is alive: " + t3.getThread().isAlive());

        try {
            System.out.println("Waiting for threads to finish");
            t1.getThread().join();
            t2.getThread().join();
            t3.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println(t1.getThread().getName() + " thread is alive: " + t1.getThread().isAlive());
        System.out.println(t2.getThread().getName() + " thread is alive: " + t2.getThread().isAlive());
        System.out.println(t3.getThread().getName() + " thread is alive: " + t3.getThread().isAlive());

        System.out.println("Main thread exiting");
         */

        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread exiting");
         */

        /*
        new DemoRThread();
        new DemoTThread();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");

         */

        /*
        Thread thread = Thread.currentThread();
        System.out.println("Current thread is " + thread);
        System.out.println("Current thread name is " + thread.getName());
        thread.setName("My thread");
        System.out.println("Current thread after name change is " + thread);
        try {
            for(int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

         */
    }

}








