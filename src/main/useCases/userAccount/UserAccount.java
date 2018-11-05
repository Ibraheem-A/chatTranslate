package useCases.userAccount;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class UserAccount {
    private final Map<UserDetails, Account> accounts = new LinkedHashMap<>();

    public List<Account> accounts() {
        return List.copyOf(accounts.values());
    }

    UserAccount add(UserDetails details) {
        if (!accounts.containsKey(details)) {
            accounts.put(details, new Account(details));
        } else {
            Account existingItem = accounts.get(details);
            accounts.put(details, existingItem);
        }
        return this;
    }


    static class Account {
        private final UserDetails details;


        public Account(UserDetails login) {
            this.details = login;

        }

    }
}