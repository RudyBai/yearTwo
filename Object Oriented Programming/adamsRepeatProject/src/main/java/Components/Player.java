package Components;

public class Player extends Person {

    private int goalNumber;
    private boolean goalie;

    Player(Name name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.goalNumber = 0;
        this.goalie = false;
    }

    public int getGoalNumber() {
        return goalNumber;
    }

    public void setGoalNumber(int goalNumber) {
        this.goalNumber = goalNumber;
    }

    public boolean isGoalie() {
        return goalie;
    }

    public void setGoalie(boolean goalie) {
        this.goalie = goalie;
    }
}
