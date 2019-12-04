package Components;

import java.util.ArrayList;

public class League {

    private ArrayList<Team> teamArrayList;
    private String name;

    public League(String name) {
        this.name = name;
        this.teamArrayList = new ArrayList<>();
    }

    public League(String name, ArrayList<Team> teamArrayList) {
        this.name = name;
        this.teamArrayList = teamArrayList;
    }

    public ArrayList<Team> getTeamArrayList() {
        return teamArrayList;
    }

    public void setTeamArrayList(ArrayList<Team> teamArrayList) {
        this.teamArrayList = teamArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
