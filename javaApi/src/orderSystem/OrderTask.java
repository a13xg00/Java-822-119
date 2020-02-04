package orderSystem;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderTask implements Runnable {

    private Set<Order> orders;

    public OrderTask(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public static boolean ifReady(LocalDateTime current){
        return current.equals(LocalDateTime.now());
    }

    @Override
    public void run() {
        while (true){
            for (Order order: orders
            ) {
                if (ifReady(order.getReadyOn())
                        && !order.isPoped()
                        && !order.isImportant()){
                    System.out.print(order);
                    order.setPoped(true);
                }else if (order.isImportant() && !order.isPoped()){
                    ImportantOrderTask importantOrderTask = new ImportantOrderTask(order);
                    Thread importantOrderThread = new Thread(importantOrderTask);
                    importantOrderThread.start();
                }
            }
        }
    }
}
