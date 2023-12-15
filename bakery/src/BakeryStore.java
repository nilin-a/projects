public class BakeryStore {
    private int bunAmount = 0;
    private int maxBunAmount = 20;

    public int getMaxBunAmount() {
        return this.maxBunAmount;
    }

    public synchronized void bakeBuns() {
        while (bunAmount > 4) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Процесс ожидания продажи булок прерван");
            }
        }
        System.out.println("Кондитер испек одну булку! Всего булок: " + ++bunAmount);
        maxBunAmount--;
        notify();
    }

    public synchronized void buyBuns() {
        while (bunAmount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Процесс ожидания покупки булок прерван");
            }
        }
        System.out.printf("Любитель булок купил %d булок!\n", bunAmount);
        bunAmount = 0;
        notify();
    }
}
