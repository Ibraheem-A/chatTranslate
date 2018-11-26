package translate.useCases.Messaging;

import java.util.List;

interface MessageRepository {

    List<Messages> fetchMessages();

    void addMessage(Messages messages);
}

