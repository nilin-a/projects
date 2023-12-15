package withSynchronized;

public class SCallThread implements Runnable {
    private SCall call;
    private int duration;
    private String appName;
    public SCallThread(SCall call, String appName, int duration) {
        this.call = call;
        this.duration = duration;
        this.appName = appName;
    }

    public void run() {
        call.makeCall(duration, appName);
    }
}
