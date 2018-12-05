package translate.useCases.messaging;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;
import translate.useCases.translation.Translation;
import translate.useCases.userAccount.UserAccounts;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    MessageService messageService = new MessageService();
    Translation translation = new Translation();

    @RequestMapping(path = "messages", method = RequestMethod.GET)
    public List<MessagesDTO> getMessages(@RequestHeader(name ="Username") String username, @RequestParam(name="Language", required = false) String language)  {

        if (new UserAccounts().doesAccountExist(username)) {
            return messageService.getMessages(username).stream()
                    .map((Messages message) -> Translation.trn(message, language))
                    .map(MessagesDTO::from)
                    .collect(Collectors.toList());
        }
        else {
            return Collections.emptyList();
        }
    }


    @RequestMapping(path = "messages", method = RequestMethod.POST)
    public void composeMessages(@RequestHeader (name = "Username") String username, @RequestBody MessagesDTO messagesDTO) {
        if (new UserAccounts().doesAccountExist(username)){
            Messages messages = new Messages(messagesDTO.getMessages(), username);
            messageService.addToMessageList(messages, messagesDTO.getUser());
        }
        else {
            throw new IllegalArgumentException();
        }
    }



}
