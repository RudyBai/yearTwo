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
