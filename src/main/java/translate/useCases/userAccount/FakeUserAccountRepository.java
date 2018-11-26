package translate.useCases.userAccount;

public class FakeUserAccountRepository implements UserAccountRepository {
    private UserAccounts userAccounts = new UserAccounts();


    @Override
    public void persistUserAccount(UserAccounts userAccounts) {
            this.userAccounts = userAccounts;
        }

    @Override
    public UserAccounts fetchUserAccount() {
            return userAccounts;
        }

}
