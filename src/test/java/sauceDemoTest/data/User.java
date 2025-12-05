package sauceDemoTest.data;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;

    public User(String username, String firstName, String lastName, String zipCode) {
        this.username = username;
        this.password = "secret_sauce";
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public User() {
        this.password = "secret_sauce";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
