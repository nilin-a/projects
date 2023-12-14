public class Call {

    public void call(String app, int callDuration) {
        callDuration = 0;
        System.out.printf("Входящий вызов из %s\n", app);
        try {
            Thread.sleep(callDuration);
        } catch (InterruptedException e) {
            System.out.printf("Вызов из %s прерван\n", app);
        }
        System.out.printf("Вызов из %s завершен\n. Вызов продлился %d", app, callDuration);

    }
}
