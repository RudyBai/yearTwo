package Components;

import java.util.ArrayList;

public class Team {

    private Manager manager;
    private ArrayList<Player> playerArrayList;
    private String color;

    public Team(Manager manager, ArrayList<Player> playerArrayList, String color) {
        this.manager = manager;
        this.playerArrayList = playerArrayList;
        this.color = color;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }

    public void setPlayerArrayList(ArrayList<Player> playerArrayList) {
        this.playerArrayList = playerArrayList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
