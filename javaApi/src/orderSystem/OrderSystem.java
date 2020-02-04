package orderSystem;

import java.time.LocalDateTime;
import java.util.*;

public class OrderSystem {

    private Set<Order> orders;
    private OrderTask orderTask;
    private Thread orderThread;

    public OrderSystem() {
        orders = new HashSet<>();
        orderTask = new OrderTask(orders);
        orderThread = new Thread(orderTask);
    }

    public Thread getOrderThread() {
        return orderThread;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public boolean addOrder(Order order) {
        if (order.getReadyOn().isAfter(LocalDateTime.now())) {
            Set<Order> newOrder = new HashSet<>(orders);
            boolean isSuccess = newOrder.add(order);
            setOrders(newOrder);
            orderTask.setOrders(orders);
            return isSuccess;
        }
        System.out.println("Back to the future...");
        return false;
    }

    public List<Order> getOrders() {
        List<Order> newOrders = new ArrayList<>();
        for (Order order : orders) {
            newOrders.add(order);
        }
        Collections.sort(newOrders);
        return newOrders;
    }


}
