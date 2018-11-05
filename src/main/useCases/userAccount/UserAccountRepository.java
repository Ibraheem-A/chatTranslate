package useCases.userAccount;

public interface UserAccountRepository {
        void persistUserAccount(UserAccount userAccount);

        UserAccount fetchUserAccount();
}
