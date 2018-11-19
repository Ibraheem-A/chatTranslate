package useCases.userAccount;

public class UserAccountService {
        private final UserAccountRepository userAccountRepository;

        public UserAccountService(UserAccountRepository userAccountRepository) {
            this.userAccountRepository = userAccountRepository;
        }

        public UserAccounts getCurrentUserAccount() {
            return userAccountRepository.fetchUserAccount();
        }

        public void addToCurrentUserAccount(Login login) {
            UserAccounts userAccounts = userAccountRepository.fetchUserAccount();
            userAccounts.add(login);
            userAccountRepository.persistUserAccount(userAccounts);
        }
}
