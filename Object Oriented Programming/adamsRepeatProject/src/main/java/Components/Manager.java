package Components;

import java.time.LocalDate;

public class Manager extends Person {

    private LocalDate dateOfBirth;
    private int stars;

    Manager(Name name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.dateOfBirth = LocalDate.of(1998, 10, 30);
        this.stars = 0;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
