import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        CallingApp telegram = new CallingApp("Telegram");
        CallingApp vk = new CallingApp("VK");
        CallingApp zoom = new CallingApp("Zoom");

        telegram.getThread().start();
        Thread.sleep(3000);
        vk.getThread().start();
        Thread.sleep(4000);
        zoom.getThread().start();
        Thread.sleep(3000);




    }
}