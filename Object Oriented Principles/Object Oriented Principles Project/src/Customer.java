import java.util.ArrayList;
class Customer {

    // Attributes
    private String name;
    private String address;
    private ArrayList<Order> orders;

    // Constructor
    Customer(String parameterName, String parameterAddress) {
        this.name = parameterName;
        this.address = parameterAddress;
        this.orders = new ArrayList<>();
    }

    // Getters

    String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    ArrayList<Order> getOrders() {
        return orders;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // Add Order
    void addOrder(Order order) {
        this.orders.add(order);
    }

    // Print
    void print() {
        System.out.println(
                "Name : " + this.name + "\nAddress : " + this.address + "\n"
        );
        for (Order order: orders
             ) {order.print();

        }
    }
}
