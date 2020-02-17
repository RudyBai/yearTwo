public abstract class Product {

    // Attributes

    private static int globalIDCounter;

    private String name;
    private String description;
    private int productID;
    private double price;

    public Product(String parameterName, String parameterDescription, double parameterPrice) {
        this.name = parameterName;
        this.description = parameterDescription;
        this.productID = globalIDCounter;
        globalIDCounter++;
        this.price = parameterPrice;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    // Print

    public abstract void print();
}
