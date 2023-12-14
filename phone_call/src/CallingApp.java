import java.util.concurrent.locks.ReentrantLock;

public class CallingApp implements Runnable{
    private String appName;
    private Thread thread;
    private int callDuration;

    private boolean isActive;

    public CallingApp(String appName) {
        this.appName = appName;
        this.thread = new Thread(appName);
        System.out.println("Входящий вызов из " + appName);
    }

    public String getAppName() {
        return this.appName;
    }
    public Thread getThread() {
        return this.thread;
    }
    public int getCallDuration() {
        return this.callDuration;
    }

    public void endCall() {
        this.isActive = false;
        notify();
    }

    public void run() {
        synchronized (this) {
            callDuration = 0;
            try {
                while (isActive) {
                    Thread.sleep(1000);
                    callDuration++;
                }
                System.out.printf("Вызов из %s завершен. Длительность вызова: %d", getAppName(), getCallDuration());

            } catch (InterruptedException e) {
                System.out.printf("Вызов из %s прерван", getAppName());
            }
        }
    }
}
