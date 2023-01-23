package lk.blacky.bakerymanagement.to;

public class Cashier {
    private   String userName;
    private String password;

    public Cashier() {
    }

    public Cashier(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
