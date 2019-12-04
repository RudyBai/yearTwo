package Components;

import java.io.Serializable;

public class Person implements Serializable {
    private Name name;
    private String email;
    private String phoneNumber;

    Person(Name name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
