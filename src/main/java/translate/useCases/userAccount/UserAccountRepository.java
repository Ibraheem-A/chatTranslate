package translate.useCases.userAccount;

public interface UserAccountRepository {
        void persistUserAccount(UserAccounts userAccounts);

        UserAccounts fetchUserAccount();
}
