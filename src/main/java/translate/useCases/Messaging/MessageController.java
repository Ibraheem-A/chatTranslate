package translate.useCases.Messaging;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    MessageService messageService = new MessageService();

    @RequestMapping(path = "messages", method = RequestMethod.GET)
    public List<MessagesDTO> getMessages() {
        return messageService.getMessages()
                .stream()
                .map(MessagesDTO::from)
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "messages", method = RequestMethod.POST)
    public void composeMessages(@RequestBody MessagesDTO messagesDTO) {
        messageService.addToMessageList(messagesDTO.toMessages());
    }

}
