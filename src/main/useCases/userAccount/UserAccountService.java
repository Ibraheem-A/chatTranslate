package useCases.userAccount;

public class UserAccountService {
        private final UserAccountRepository userAccountRepository;

        public UserAccountService(UserAccountRepository userAccountRepository) {
            this.userAccountRepository = userAccountRepository;
        }

        public UserAccount getUserAccount() {
            return userAccountRepository.fetchUserAccount();
        }

        public void addToCurrentUserAccount(UserDetails userDetails) {
            UserAccount userAccount = userAccountRepository.fetchUserAccount();
            userAccount.add(userDetails);
            userAccountRepository.persistUserAccount(userAccount);
        }
}
