package useCases.userAccount;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



public class UserAccounts {
    private final Map<Login, Account> accounts = new LinkedHashMap<>();

    public List<Account> accounts() {
        return List.copyOf(accounts.values());
    }

    UserAccounts add(Login login) {
        if (!accounts.containsKey(login)) {
            accounts.put(login, new Account(login));
        } else {
            Account existingItem = accounts.get(login);
            accounts.put(login, existingItem);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccounts that = (UserAccounts) o;
        return Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    @Override
    public String toString() {
        return "UserAccounts{" +
                "accounts=" + accounts +
                '}';
    }

    static class Account {
        private final Login login;

        public Account(Login login) {
            this.login = login;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return Objects.equals(login, account.login);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login);
        }

        @Override
        public String toString() {
            return "Account{" +
                    "login=" + login +
                    '}';
        }
    }
}