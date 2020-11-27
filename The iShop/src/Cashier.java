import java.util.concurrent.ThreadLocalRandom;

public class Cashier extends Thread {
	
	private boolean closed = false;
	private int serveNextCustomer;
	private String[] logProductInBasket;

    @Override
    public void run() {
        for (int i = 0; i < Main.customersCurrentlyInShop; i++) {
            try {
                //Main.lineCustomerReady.acquire();
                checkout(i);
                //Main.lineCustomers[i].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[CASHIER] goes home");
    }

    private void checkout(int i) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        System.out.println("[CASHIER] checks out customer " + i);
    }
}