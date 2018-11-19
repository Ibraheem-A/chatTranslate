package useCases.userAccount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserAccountsServiceTests {
    private final UserAccountRepository userAccountRepository = new FakeUserAccountRepository();
    private final UserAccountService subject = new UserAccountService(userAccountRepository);

    @Test
    void cartShouldBeInitiallyEmpty() {
        UserAccounts result = subject.getCurrentUserAccount();

        assertEquals(List.of(), result.accounts());
    }

    @Test
    void cartShouldBeAbleToAddOneAccount() {
        LoginDetails loginDetails = new LoginDetails("Ibraheem", "qwerty");
        subject.addToCurrentUserAccount(loginDetails);

        UserAccounts result = subject.getCurrentUserAccount();

        List<UserAccounts.Account> expected = List.of(new UserAccounts.Account(loginDetails));

        assertEquals(expected, result.accounts());

    }

    @Test
    void cartShouldBeAbleToAllowUserLogin() {
        LoginDetails loginDetails = new LoginDetails("Ibraheem", "qwerty");
        subject.addToCurrentUserAccount(loginDetails);

        UserAccounts result = subject.getCurrentUserAccount();
        List<UserAccounts.Account> expected = List.of(new UserAccounts.Account(loginDetails));

        LoginDetails loginDetails2 = new LoginDetails("Ibraheem", "qwerty");
        subject.loginToUserAccount(loginDetails2);
        UserAccounts result2 = subject.getCurrentUserAccount();


    }
}
