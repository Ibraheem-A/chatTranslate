package translate.useCases.messaging;

public class ReceiveMessagesDTO {
    private String messages;
    private String userReciever;

    public ReceiveMessagesDTO() {
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getUserReciever() {
        return userReciever;
    }

    public void setUserReciever(String userReciever) {
        this.userReciever = userReciever;
    }
}
