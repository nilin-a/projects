import java.util.concurrent.locks.ReentrantLock;

public class CallThread implements Runnable{
    ReentrantLock locker;
    private String callingApp;
    private int duration;
    public CallThread(ReentrantLock lock, String callingApp, int duration){
        this.locker = lock;
        this.callingApp = callingApp;
        this.duration = duration;
    }

    public String getCallingApp() {
        return this.callingApp;
    }
    public int getDuration() {
        return this.duration;
    }
    public void run(){
        locker.lock();
        try{
            System.out.println("Звонок от " + getCallingApp());
            Thread.sleep(duration);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Звонок от " + getCallingApp() + " завершен. Длительность: " + getDuration());
            locker.unlock();

        }
    }
}
