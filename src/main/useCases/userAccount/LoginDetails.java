package useCases.userAccount;

import java.util.Objects;

public class LoginDetails {


    private final String userName;
    private final String password;


    public LoginDetails(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }


    @Override
    public String toString() {
        return "LoginDetails{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDetails login = (LoginDetails) o;
        return Objects.equals(userName, login.userName) &&
                Objects.equals(password, login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }



}
