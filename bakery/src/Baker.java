public class Baker implements Runnable{
    private BakeryStore store;
    public Baker(BakeryStore store) {
        this.store = store;
    }
    public void run() {
        for (int i = 0; i < store.getMaxBunAmount(); i++) {
            store.bakeBuns();
        }
    }
}
