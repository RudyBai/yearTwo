import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GeneralController {
    private int stars;
    private ListView<String> listView;
    private HashMap<String, String[]> prizeHashMap;

    GeneralController() {
        this.stars = 0;
        this.listView = new ListView<>();
        this.prizeHashMap = new HashMap<>();
    }

    void refreshList(Stage stage) {
        stage.setTitle(String.format("Star count : %d", this.stars));
        List<String> prizeList = new ArrayList<>();
        File file = new File("C:\\Users\\walus\\OneDrive - mycit.ie\\Object Oriented Programming\\Java-FX\\Assignment One Redone\\src\\prizes.txt");
        try {
            prizeList = Files.readAllLines(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.prizeHashMap = new HashMap<>();

        for (String s : prizeList) {
            String[] costPrize = {s.split(":")[1], s.split(":")[2]};
            this.prizeHashMap.put((s.split(":")[0]), costPrize);
        }
        ArrayList<String> keys = new ArrayList<>(this.prizeHashMap.keySet());
        ArrayList<String> fruit = new ArrayList<>();
        for (int i = 0; i < this.prizeHashMap.size(); i++) {
            if (Integer.parseInt(this.prizeHashMap.get(keys.get(i))[0]) <= this.stars) {
                fruit.add(keys.get(i));
            }
        }

        ObservableList<String> observableList;
        observableList = FXCollections.observableList(fruit);
        this.listView.setItems(observableList);
    }

    int getStars() {
        return stars;
    }

    void setStars(int stars) {
        this.stars = stars;
    }

    ListView<String> getListView() {
        return listView;
    }

    HashMap<String, String[]> getPrizeHashMap() {
        return prizeHashMap;
    }
}
