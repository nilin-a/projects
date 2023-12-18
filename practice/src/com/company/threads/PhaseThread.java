package com.company.threads;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable{
    private Phaser phaser;
    private String name;

    public PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        this.phaser.register();
    }

    public void run() {
        System.out.println(name + ": фаза " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name + ": фаза " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name + ": фаза " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
