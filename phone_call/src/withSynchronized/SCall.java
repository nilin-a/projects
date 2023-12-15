package withSynchronized;

public class SCall {
    public synchronized void makeCall(int duration, String appName) {
        int currentDuration = 0;
        while (currentDuration < duration) {
            System.out.printf("Звонок в %s...\n", appName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentDuration += 1000;
        }
        System.out.printf("Звонок в %s завершен. Длительность: %d\n", appName, duration);
    }
}
