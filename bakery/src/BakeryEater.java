public class BakeryEater implements Runnable{
    private BakeryStore store;
    public BakeryEater(BakeryStore store) {
        this.store = store;
    }
    public void run() {
        for(int i = 0; i < store.getMaxBunAmount(); i++) {
            store.buyBuns();
        }
    }
}
