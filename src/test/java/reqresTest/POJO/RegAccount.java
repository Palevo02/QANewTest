package reqresTest.POJO;

public class RegAccount {
    private String username;
    private String email;
    private String password;

    public RegAccount(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public RegAccount(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
