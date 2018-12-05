package translate.useCases.messaging;


import java.util.Collection;
import java.util.List;

public class MessageService {

    private final MessageRepository messageRepository = new Messaging();

    public void addToMessageList (Messages messages){
        messageRepository.addMessage(messages);
    }


    public List <Messages> getMessages() {
        return messageRepository.fetchMessages();
    }

    public void addToMessageList(Messages messages, String userName) {
        messageRepository.addMessage(messages, userName);
    }

    public List<Messages> getMessages(String username) {
        return messageRepository.fetchMessages(username);
    }
}
