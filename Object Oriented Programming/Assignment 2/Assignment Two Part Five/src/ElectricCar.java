public class ElectricCar extends Car {

    enum Engine {
        FULL_ELECTRIC,
        HYBRID
    }
    // Attributes
    private Engine engine;

    ElectricCar(String make, String model, String registration, double millage, int yearOfManufacture, Engine engine) {
        super(make, model, registration, millage, yearOfManufacture);
        this.engine = engine;

    }

    @Override
    public String toString() {
        return super.toString() + "\nEngine\t\t\t\t : " + this.engine;
    }
}
