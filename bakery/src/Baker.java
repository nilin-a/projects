public class Baker implements Runnable{
    private BakeryStore store;
    public Baker(BakeryStore store) {
        this.store = store;
    }
    public void run() {
        while (store.getMaxBunAmount() != 0) {
            store.bakeBuns();
        }
    }
}
