package translate.useCases.messaging;

import java.util.List;

interface MessageRepository {

    List<Messages> fetchMessages();

    void addMessage(Messages messages);

    void addMessage(Messages messages, String recipient);

    List<Messages> fetchMessages(String username);
}

