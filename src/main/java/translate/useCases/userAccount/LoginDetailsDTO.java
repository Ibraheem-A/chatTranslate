package translate.useCases.userAccount;

public class LoginDetailsDTO {

    private String username;
    private String password;

    public void LoginDetailsDTO(String username, String password){
        this.username = username;
        this.password = password;
    }

    public LoginDetails toLogin(){
        return new LoginDetails(this.username, this.password);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
