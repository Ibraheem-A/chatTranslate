package translate.useCases.messaging;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Messaging implements MessageRepository {

    private List <Messages> messageList =  new ArrayList<>();

    @Override
    public List<Messages> fetchMessages() {
        return ImmutableList.copyOf(messageList);
    }

    @Override
    public void addMessage(Messages messages) {
        messageList.add(messages);
    }
}
