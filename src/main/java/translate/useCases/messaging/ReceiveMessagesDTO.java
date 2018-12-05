package translate.useCases.messaging;

public class ReceiveMessagesDTO {
    private String messages;
    private String userReceiver;

    public ReceiveMessagesDTO() {
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(String userReceiver) {
        this.userReceiver = userReceiver;
    }
}
