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
        Login login = new Login("Ibraheem", "qwerty");
        subject.addToCurrentUserAccount(login);

        UserAccounts result = subject.getCurrentUserAccount();

        List<UserAccounts.Account> expected = List.of(new UserAccounts.Account(login));

        assertEquals(expected, result.accounts());

    }

    @Test
    void cartShouldBeAbleToAllowUserLogin() {
        Login login = new Login("Ibraheem", "qwerty");
        subject.addToCurrentUserAccount(login);

        UserAccounts result = subject.getCurrentUserAccount();
        assertEquals(List.of(new UserAccounts.Account(login)), result);
    }
}
