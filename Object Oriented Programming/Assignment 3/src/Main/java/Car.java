import java.io.Serializable;

/**
 * Car object for assignment
 */
public class Car implements Serializable, Comparable<Car> {
    private String make;
    private String model;
    private String registration;
    private double millage;
    private int yearOfManufacture;

    /**
     * @param make              make of car e.g. Ford
     * @param model             model of car e.g. Focus
     * @param registration      registration of car e.g. 131-C-5345
     * @param millage           the distance the car has travelled e.g. 13987.5km
     * @param yearOfManufacture the year in which the car was manufactured e.g. 2013
     */
    Car(String make, String model, String registration, double millage, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.registration = registration;
        this.millage = millage;
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * @return make getter
     */
    private String getMake() {
        return make;
    }

    /**
     * @return model getter
     */
    private String getModel() {
        return model;
    }

    /**
     * @return millage getter
     */
    private double getMillage() {
        return millage;
    }

    /**
     * @return year of maufacture getter
     */
    private int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Override toString
     *
     * @return String to be printed
     */
    @Override
    public String toString() {
        return "Make\t\t\t\t : " + make + "\nModel\t\t\t\t : " + model + "\nRegistration\t\t\t : " + registration + "\nMillage\t\t\t\t : " + millage + "\nYear of Manufacture\t : " + yearOfManufacture;
    }

    /**
     * Override default comparator
     *
     * @param car car to be compared TO
     * @return negative integer if smaller, 0 if equal, positive if bigger
     */
    @Override
    public int compareTo(Car car) {
        if (this.make.compareTo(car.getMake()) != 0) {
            return this.model.compareTo(car.getModel());
        } else {
            return this.make.compareTo(car.getMake());
        }
    }

    /**
     * Alternative comparator
     *
     * @param car car to be compared TO
     * @return negative integer if smaller, 0 if equal, positive if bigger
     */
    int millageCompare(Car car) {
        return Integer.compare((int) this.millage, (int) car.getMillage());
    }

    /**
     * Alternative comparator
     *
     * @param car car to be compared TO
     * @return negative integer if smaller, 0 if equal, positive if bigger
     */
    int yearCompare(Car car) {
        return Integer.compare(this.yearOfManufacture, car.getYearOfManufacture());
    }
}
