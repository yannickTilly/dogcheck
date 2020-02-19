package meyti.dogcheck.Model.RequestBody;

public class PostToken {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public PostToken setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PostToken setPassword(String password) {
        this.password = password;
        return this;
    }
}
