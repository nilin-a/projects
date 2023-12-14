import java.util.concurrent.locks.ReentrantLock;

public class CallingApp implements Runnable{
    private String appName;
    private Thread thread;
    private Call call;
    private int duration;

    public CallingApp(String appName, int duration, Call call) {
        this.appName = appName;
        this.duration = duration;
        this.call = call;
        this.thread = new Thread(appName);
        thread.start();
    }

    public Thread getThread() {
        return this.thread;
    }

    public void run() {
        synchronized (call) {
            call.call(appName, duration);
        }
    }
}
