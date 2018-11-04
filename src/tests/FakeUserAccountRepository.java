package tests;

import main.useCases.userAccount.UserAccount;
import main.useCases.userAccount.UserAccountRepository;

public class FakeUserAccountRepository {
    public class FakeUserAccountRepository implements UserAccountRepository {
        private UserAccount userAccount = new UserAccount();

        @Override
        public void persistUserAccount(UserAccount userAccount) {
            this.userAccount = userAccount;
        }

        @Override
        public UserAccount fetchUserAccount() {
            return userAccount;
        }
    }
}
