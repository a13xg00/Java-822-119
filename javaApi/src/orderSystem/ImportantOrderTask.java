package orderSystem;

public class ImportantOrderTask implements Runnable {

    private Order order;

    public ImportantOrderTask(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        try {
            System.out.println(order);
            Thread.sleep(60000);
            System.out.println(order);
            Thread.sleep(60000);
            System.out.println(order);
            order.setPoped(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
