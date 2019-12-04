
public class Main {

    public static void main(String[] args) {
        Car car = new Car("A", "A", "A", 1, 1);
        System.out.println(car);
        ElectricCar electricCar = new ElectricCar("B", "B", "B", 2, 2, ElectricCar.Engine.FULL_ELECTRIC);
        System.out.println(electricCar);
        ElectricCar electricCar1 = new ElectricCar("C", "C", "C", 3, 3, ElectricCar.Engine.HYBRID);
        System.out.println(electricCar1);
    }

}
