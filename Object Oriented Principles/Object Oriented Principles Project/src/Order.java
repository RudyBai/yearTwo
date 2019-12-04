class Order {

    // Attributes

    private Product product;
    private int quantity;

    // Constructor

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters

    Product getProduct() {
        return product;
    }

    int getQuantity() {
        return quantity;
    }

    // Setters

    void setProduct(Product product) {
        this.product = product;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Print

    void print() {
        System.out.println("Product : " + this.product.getName());
        System.out.println("Quantity : " + this.quantity);
    }
}
