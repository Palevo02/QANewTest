package ReqresTest.POJO;

public class RequestAccount {
    private String email;
    private String password;

    public RequestAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RequestAccount(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
