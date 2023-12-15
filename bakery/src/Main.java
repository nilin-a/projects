public class Main {
    public static void main(String[] args) {
        BakeryStore store = new BakeryStore();
        Baker baker = new Baker(store);
        BakeryEater bakeryEater = new BakeryEater(store);
        new Thread(baker).start();
        new Thread(bakeryEater).start();
    }
}