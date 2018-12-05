package translate.useCases.messaging;

public class SendMessageDTO {
    private String messages;
    private String userSender;

    public SendMessageDTO() {
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }
}
