import java.util.ArrayList;
class Customer {

    // Attributes
    private String name;
    private ArrayList<Order> orders;

    // Constructor
    Customer(String parameterName) {
        this.name = parameterName;
        this.orders = new ArrayList<>();
    }

    // Getters

    String getName() {
        return name;
    }

    ArrayList<Order> getOrders() {
        return orders;
    }

    // Add Order
    void addOrder(Order order) {
        this.orders.add(order);
    }
}
