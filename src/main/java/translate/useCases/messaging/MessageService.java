package translate.useCases.messaging;


import java.util.List;

public class MessageService {

    private final MessageRepository messageRepository = new Messaging();

    public void addToMessageList (Messages messages){
        messageRepository.addMessage(messages);
    }


    public List <Messages> getMessages() {
        return messageRepository.fetchMessages();
    }
}
