package com.company;

import com.company.threads.DemoRThread;
import com.company.threads.DemoTThread;
import com.company.threads.EditableThread;

public class Main {

    public static void main(String[] args) {

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








