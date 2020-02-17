public class Phone extends Product {

    // Attributes

    private String make;
    private String model;
    private double storageSpace;

    // Constructor

    public Phone(String name, String desc, double price, String make, String model, double storage) {
        super(name, desc, price);
        this.make = make;
        this.model = model;
        this.storageSpace = storage;
    }

    // Print

    public void print() {
        System.out.println("Name            : " + this.getName());
        System.out.println("Description     : " + this.getDescription());
        System.out.println("Price           : " + this.getPrice());
        System.out.println("Make            : " + this.make);
        System.out.println("Model           : " + this.model);
        System.out.println("Storage Space   : " + this.storageSpace);
    }
}
