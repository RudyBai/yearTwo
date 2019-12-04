import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

/**
 * Controller for CarListTab
 */
public class CarListTabController {

    private CarListTab carListTab;

    /**
     * @param carListTab carListTab to be controlled
     */
    CarListTabController(CarListTab carListTab) {
        this.carListTab = carListTab;
    }

    /**
     * @param car car to be added to list
     */
    void addCar(Car car) {
        carListTab.getCarObservableList().add(car);
        System.out.println("Car added!");
    }

    /**
     * @param car car to be removed from list
     */
    void remove(Car car) {
        carListTab.getCarObservableList().remove(car);
        System.out.println("Car removed!");
    }

    /**
     * save all cars in list to txt file
     * @param carArrayList carArrayList to be saved to txt file
     */
    void save(ArrayList<Car> carArrayList) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("cars.txt"));
            objectOutputStream.writeObject(carArrayList);
            System.out.println("Save Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load all cars in txt file to running instance
     */
    void load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cars.txt"));
            ArrayList arrayList = (ArrayList) objectInputStream.readObject();
            ArrayList<Car> carArrayList = new ArrayList<>();

            for (Object object : arrayList) {
                if (object instanceof Car) {
                    carArrayList.add((Car) object);
                }
            }

            if (carArrayList.size() == 0) {
                Alert noData = new Alert(Alert.AlertType.INFORMATION);
                noData.setTitle("No Data");
                noData.setHeaderText("No Data");
                noData.setContentText("The save file contains an empty set of data.");
                noData.showAndWait();
                return;            }

            System.out.println("Load successful");

            ObservableList<Car> carObservableList = carListTab.getCarObservableList();
            carObservableList.addAll(carArrayList);

            carListTab.setCarObservableList(carObservableList);

        } catch (EOFException e) {
            e.printStackTrace();
            Alert eofAlert = new Alert(Alert.AlertType.INFORMATION);
            eofAlert.setTitle("End of File");
            eofAlert.setHeaderText("End of File");
            eofAlert.setContentText("The save file contains no data.");
            eofAlert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alert ioAlert = new Alert(Alert.AlertType.INFORMATION);
            ioAlert.setTitle("I/O Alert");
            ioAlert.setHeaderText("I/O Alert");
            ioAlert.setContentText("The save file may be corrupted.");
            ioAlert.showAndWait();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Alert classAlert = new Alert(Alert.AlertType.INFORMATION);
            classAlert.setTitle("Class Not Found");
            classAlert.setHeaderText("Class not found");
            classAlert.setContentText("The save file contains the wrong class type objects.");
            classAlert.showAndWait();
        }
    }

    /**
     * Order list alphabetically
     */
    void alphaOrder() {
        ArrayList<Car> carArrayList = new ArrayList<>(carListTab.getCarObservableList());

        while (carListTab.getCarObservableList().size() > 0) {
            remove(carListTab.getCarObservableList().get(0));
        }

        carArrayList.sort(Car::compareTo);

        for (Car car : carArrayList) {
            addCar(car);
        }
    }

    /**
     * Order list by millage
     */
    void millageOrder() {
        ArrayList<Car> carArrayList = new ArrayList<>(carListTab.getCarObservableList());

        while (carListTab.getCarObservableList().size() > 0) {
            remove(carListTab.getCarObservableList().get(0));
        }

        carArrayList.sort(Car::millageCompare);

        for (Car car : carArrayList) {
            addCar(car);
        }
    }

    /**
     * Order list by yearOfManufacture
     */
    void yearOrder() {
        ArrayList<Car> carArrayList = new ArrayList<>(carListTab.getCarObservableList());

        while (carListTab.getCarObservableList().size() > 0) {
            remove(carListTab.getCarObservableList().get(0));
        }

        carArrayList.sort(Car::yearCompare);

        for (Car car : carArrayList) {
            addCar(car);
        }
    }
}
