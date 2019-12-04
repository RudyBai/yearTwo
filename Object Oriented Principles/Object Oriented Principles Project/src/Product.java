public abstract class Product {

    // Attributes

    private static int globalIDCounter;

    private String name;
    private String description;
    private int productID;
    private double price;

    // Constructor
    public Product() {}

    public Product(String parameterName, String parameterDescription, double parameterPrice) {
        this.name = parameterName;
        this.description = parameterDescription;
        this.productID = globalIDCounter;
        globalIDCounter++;
        this.price = parameterPrice;
    }

    // Getters

    public static int getGlobalIDCounter() {
        return globalIDCounter;
    }

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

    // Setters (Without globalIDCounter setter)

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Print

    public abstract void print();
}
