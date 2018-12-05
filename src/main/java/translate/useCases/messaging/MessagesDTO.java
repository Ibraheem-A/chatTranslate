package translate.useCases.messaging;

public class MessagesDTO {

    private String messages;

    private String user;

    MessagesDTO() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    MessagesDTO(String messages, String user) {
        this.messages = messages;
        this.user = user;
    }

    public static MessagesDTO from(Messages messages) {
        return new MessagesDTO(messages.getMessage(), messages.getSender());
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
