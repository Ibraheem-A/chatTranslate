package translate.useCases.messaging;

import com.google.common.collect.ImmutableList;

import java.util.*;

public class Messaging implements MessageRepository {

    private List <Messages> messageList =  new ArrayList<>();

    private Map<User, List<Messages>> userMessages = new HashMap<>();

    @Override
    public List<Messages> fetchMessages() {
        return ImmutableList.copyOf(messageList);
    }

    @Override
    public void addMessage(Messages messages) {
        messageList.add(messages);
    }

    @Override
    public void addMessage(Messages messages, String userName) {
        User user = new User(userName);

        if (userMessages.containsKey(user)) {
            List<Messages> messagesList = userMessages.get(user);
            messagesList.add(messages);
        } else {
            ArrayList<Messages> messagesArrayList = new ArrayList<>();
            userMessages.put(user, messagesArrayList);
            messagesArrayList.add(messages);
        }

//        userMessages.computeIfAbsent(user, x -> new ArrayList<>()).add(messages);
    }

    @Override
    public List<Messages> fetchMessages(String username) {
        User user = new User(username);
        return userMessages.getOrDefault(user, new ArrayList<>());
    }

    static class User {
        private String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(userName, user.userName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName);
        }
    }
}
