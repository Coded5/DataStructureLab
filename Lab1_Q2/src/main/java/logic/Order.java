package logic;

import java.util.ArrayList;

public class Order {

    private ArrayList<OrderItem> orderItemList;
    private static int totalOrderCount = 0;
    private int orderNumber;

    public Order() {
        this.orderItemList = new ArrayList<>();
        this.orderNumber = totalOrderCount;
        totalOrderCount++;
    }

    public OrderItem addItem(Item item, int amount) {
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getItem().getName().equals(item.getName())) {
                orderItem.increaseItemAmount(amount);
                return orderItem;
            }
        }

        OrderItem newOrderItem = new OrderItem(item, amount);
        orderItemList.add(newOrderItem);
        totalOrderCount++;

        return newOrderItem;
    }

    public int calculateOrderTotalPrice() {
        int sum = 0;
        for (OrderItem orderItem : orderItemList) {
            sum += orderItem.calculateTotalPrice();
        }

        return sum;
    }

    public static int getTotalOrderCount() {
        return totalOrderCount;
    }

    public static void resetTotalOrderCount() {
        totalOrderCount = 0;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

}
