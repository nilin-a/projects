public class BakeryStore {
    private int bunAmount = 0;
    private int maxBunAmount = 20;
    private boolean canSell = true;
    private boolean canBuy = true;

    public int getMaxBunAmount() {
        return this.maxBunAmount;
    }

    public synchronized void bakeBuns() {
        if (maxBunAmount != 0) {
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
        } else {
            System.out.println("Кондитер испек 20 булок. Его рабочий день окончен");
        }
    }

    public synchronized void buyBuns() {
        while (bunAmount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Процесс ожидания покупки булок прерван");
            }
        }
        System.out.println("Любитель булок купил одну булку! Всего булок: " + --bunAmount);
        notify();
    }
}
