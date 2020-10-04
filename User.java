package InternshipTask;

import java.sql.Timestamp;

public class User {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String status; //ACTIVE, INACTIVE, BLOCKED, NEW
    private Timestamp timestamp;

    public User(String firstname, String lastname, int age, String email, String status, Timestamp timestamp) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    //will use this at printing the users
    @Override
    public String toString() {
        return firstname + ' ' +
                lastname + ' ' +
                age + ' ' + "years old" + " \n" +
                email + "\n" +
                "Status: " + status + "\n" +
                "Registered on: " + timestamp;
    }
}
