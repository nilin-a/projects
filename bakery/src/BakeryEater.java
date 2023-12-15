public class BakeryEater implements Runnable{
    private BakeryStore store;
    public BakeryEater(BakeryStore store) {
        this.store = store;
    }
    public void run() {
        while (store.getMaxBunAmount() != 0) {
            store.buyBuns();
        }
    }
}
