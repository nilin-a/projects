import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Thread telegram = new Thread(new CallThread(locker, "Telegram", 6000));
        Thread vk = new Thread(new CallThread(locker, "VK", 3000));
        Thread zoom = new Thread(new CallThread(locker, "Zoom", 5000));
        Thread skype = new Thread(new CallThread(locker, "Skype", 1000));
        telegram.start();
        vk.start();
        zoom.start();
        skype.start();
    }
}