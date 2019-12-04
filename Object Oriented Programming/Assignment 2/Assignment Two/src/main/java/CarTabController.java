/**
 * controller for CarTab class
 */
public class CarTabController {

    // CarListTab associated with CarTab
    private CarListTab carListTab;

    // CarTab associated with controller
    private CarTab carTab;

    /**
     * Constructor for class
     *
     * Functionality depends on specific indexing of tabs
     *
     * @param carTab car tab to be controlled
     */
    CarTabController(CarTab carTab) {
        this.carTab = carTab;
        this.carListTab = (CarListTab) this.carTab.getTabPane().getTabs().get(1);
    }

    /**
     * Add car to CarListTab
     */
    void addCar() {
        Car car = new Car(
                this.carTab.getMakeField().getText(),
                this.carTab.getModelField().getText(),
                this.carTab.getRegistrationField().getText(),
                Double.parseDouble(this.carTab.getMillageField().getText()),
                Integer.parseInt(this.carTab.getYearOfManufactureField().getText()));
        this.carListTab.getCarListTabController().addCar(car);
        this.clear();
    }

    /**
     * Clear list of Cars
     */
    void clear() {
        this.carTab.getMakeField().setText("");
        this.carTab.getModelField().setText("");
        this.carTab.getRegistrationField().setText("");
        this.carTab.getMillageField().setText("");
        this.carTab.getYearOfManufactureField().setText("");
    }
}
