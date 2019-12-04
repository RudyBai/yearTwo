public class Phone extends Product {

    // Attributes

    private String make;
    private String model;
    private double storageSpace;

    // Constructor

    public Phone(String parameterName, String parameterDescription, double parameterPrice, String parameterMake, String parameterModel, double parameterStorageSpace) {
        super(parameterName, parameterDescription, parameterPrice);
        this.make = parameterMake;
        this.model = parameterModel;
        this.storageSpace = parameterStorageSpace;
    }

    //Getters

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getStorageSpace() {
        return storageSpace;
    }

    // Setters

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorageSpace(double storageSpace) {
        this.storageSpace = storageSpace;
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
