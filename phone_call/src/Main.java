import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Call call = new Call();
        CallingApp telegram = new CallingApp("Telegram", 5000, call);
        CallingApp vk = new CallingApp("VK", 7000, call);
        CallingApp zoom = new CallingApp("Zoom", 8000, call);

        try {
            zoom.getThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}