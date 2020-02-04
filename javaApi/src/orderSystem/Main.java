package orderSystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();
        Thread thread = orderSystem.getOrderThread();
        thread.start();

        String action = "";

        System.out.println(LocalDateTime.now());
        Scanner input = new Scanner(System.in);

        while(!action.equalsIgnoreCase("exit")){
            System.out.println("Pick an action(add/get/exit)");
            action = input.nextLine();

            if (action.equalsIgnoreCase("add")) {
                System.out.println("Enter year");
                int year = input.nextInt();
                System.out.println("Enter month");
                int month = input.nextInt();
                System.out.println("Enter day");
                int day = input.nextInt();
                System.out.println("Enter hour");
                int hour = input.nextInt();
                System.out.println("Enter minute");
                int minute = input.nextInt();
                System.out.println("Is Important:");
                boolean important = input.nextBoolean();
                input.nextLine();
                System.out.println("Enter order description");
                String orderDescription = input.nextLine();

                Order order = new Order(LocalDateTime.of(year, month, day, hour, minute), orderDescription, important);
                orderSystem.addOrder(order);
            }
            if (action.equalsIgnoreCase("get")){
                for (Order order: orderSystem.getOrders()
                     ) {
                    System.out.println(order);
                }
            }
        }

        thread.interrupt();
    }
}
