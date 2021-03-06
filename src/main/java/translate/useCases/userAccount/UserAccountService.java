package translate.useCases.userAccount;

public class UserAccountService {
        private final UserAccountRepository userAccountRepository = new FakeUserAccountRepository();


        public UserAccounts getCurrentUserAccount() {
            return userAccountRepository.fetchUserAccount();
        }

        public void addToCurrentUserAccount(LoginDetails loginDetails) {
            UserAccounts userAccounts = userAccountRepository.fetchUserAccount();
            userAccounts.add(loginDetails);
            userAccountRepository.persistUserAccount(userAccounts);
        }

        public void loginToUserAccount(LoginDetails loginDetails){
            UserAccounts userAccounts = userAccountRepository.fetchUserAccount();
            userAccounts.login(loginDetails);
            userAccountRepository.persistUserAccount(userAccounts);
        }

}
