package translate.useCases.messaging;

public class MessagesDTO {

    private String messages;

    MessagesDTO() {}

    MessagesDTO(String messages) {
        this.messages = messages;
    }

    public static MessagesDTO from(Messages messages) {
        return new MessagesDTO(messages.getMessage());
    }

    public Messages toMessages() {
        return new Messages(this.messages);
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
