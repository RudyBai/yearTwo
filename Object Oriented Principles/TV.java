public class TV extends Product {

    // Attributes

    private String make;
    private int screenSize;
    private String screenType;
    private boolean capable3D;

    // Constructor

    public TV (String parameterName, String parameterDescription, double parameterPrice, String parameterMake,
               int parameterScreenSize, String parameterScreenType, boolean parameterCapable3d) {
        super(parameterName, parameterDescription, parameterPrice);
        this.make = parameterMake;
        this.screenSize = parameterScreenSize;
        this.screenType = parameterScreenType;
        this.capable3D = parameterCapable3d;
    }

    // Getters

    public String getMake() {
        return make;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getScreenType() {
        return screenType;
    }

    public boolean isCapable3D() {
        return capable3D;
    }

    // Setters

    public void setMake(String make) {
        this.make = make;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setCapable3D(boolean capable3D) {
        this.capable3D = capable3D;
    }

    public void print() {
        System.out.println("Name : " + this.getName());
        System.out.println("Description : " + this.getDescription());
        System.out.println("Price : " + this.getPrice());
        System.out.println("Make : " + this.make);
        System.out.println("Screen Type : " + this.screenType);
        System.out.println("Screen Size : " + this.screenSize);
        System.out.println("3D Capable : " + this.capable3D);
    }
}
