package translate.useCases.userAccount;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



public class UserAccounts {
    private static final Map<String, Account> accounts = new LinkedHashMap<>();

    public List<Account> accounts() {
        return ImmutableList.copyOf(accounts.values());
    }


    UserAccounts add(LoginDetails loginDetails) {

        if (!accounts.containsKey(loginDetails.getUserName())) {
            accounts.put(loginDetails.getUserName(), new Account(loginDetails));
        } else {
            Account existingAccount = accounts.get(loginDetails.getUserName());
            accounts.put(loginDetails.getUserName(), existingAccount);
        }
        return this;

    }

    public boolean doesAccountExist(String username){
        return accounts().stream().anyMatch(a->a.loginDetails.getUserName().equals(username));

//        for (Account account: accounts()) {
//            if (account.loginDetails.getUserName().equals(username)) {
//                return true;
//            }
//        }
//        return false
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

    public String login(LoginDetails loginDetails) {
        if (!accounts.containsKey(loginDetails)){
            return "You are now logged in";
        }
        else {
            return "Please create a new user Account";
        }


    }

    static class Account {
        private final LoginDetails loginDetails;

        public Account(LoginDetails loginDetails) {
            this.loginDetails = loginDetails;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return Objects.equals(loginDetails, account.loginDetails);
        }

        @Override
        public int hashCode() {
            return Objects.hash(loginDetails);
        }

        @Override
        public String toString() {
            return "Account{" +
                    "login=" + loginDetails +
                    '}';
        }
    }
}