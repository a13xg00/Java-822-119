package orderSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order implements Comparable<Order> {

    private LocalDateTime readyOn;
    private String orderDescription;
    private boolean important;
    private boolean poped;

    public Order(LocalDateTime readyOn, String orderDescription, boolean important) {
        this.readyOn = readyOn;
        this.orderDescription = orderDescription;
        this.important = important;
        this.poped = false;
    }

    public Order(LocalDateTime readyOn, String orderDescription) {
        this.readyOn = readyOn;
        this.orderDescription = orderDescription;
        this.poped = false;
        this.important = false;
    }

    public LocalDateTime getReadyOn() {
        return readyOn;
    }

    public void setReadyOn(LocalDateTime readyOn) {
        this.readyOn = readyOn;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isPoped() {
        return poped;
    }

    public void setPoped(boolean poped) {
        this.poped = poped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (isImportant() != order.isImportant()) return false;
        if (isPoped() != order.isPoped()) return false;
        if (getReadyOn() != null ? !getReadyOn().equals(order.getReadyOn()) : order.getReadyOn() != null) return false;
        return getOrderDescription() != null ? getOrderDescription().equals(order.getOrderDescription()) : order.getOrderDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getReadyOn() != null ? getReadyOn().hashCode() : 0;
        result = 31 * result + (getOrderDescription() != null ? getOrderDescription().hashCode() : 0);
        result = 31 * result + (isImportant() ? 1 : 0);
        result = 31 * result + (isPoped() ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(Order o) {
        return this.readyOn.compareTo(o.readyOn);
    }

    @Override
    public String toString() {
        return "Order{" +
                "readyOn=" + readyOn +
                ", orderDescription='" + orderDescription + '\'' +
                ", important=" + important +
                ", poped=" + poped +
                '}';
    }
}
