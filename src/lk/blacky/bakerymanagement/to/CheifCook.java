package lk.blacky.bakerymanagement.to;

public class CheifCook {
    private   String userName;
    private String password;

    public CheifCook() {
    }

    public CheifCook(String userName, String password) {
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
