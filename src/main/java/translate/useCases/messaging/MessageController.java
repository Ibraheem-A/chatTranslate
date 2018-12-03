package translate.useCases.messaging;

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
    public List<MessagesDTO> getMessages(@RequestHeader(name ="Username") String username, @RequestParam(name="Language") String language)  {

        if (new UserAccounts().doesAccountExist(username)) {
            return messageService.getMessages().stream()
                    .map(Translation::trn)
                    .map(MessagesDTO::from) //
                    .collect(Collectors.toList());
        }
        else {
            return Collections.emptyList();
        }
    }


    @RequestMapping(path = "messages", method = RequestMethod.POST)
    public void composeMessages(@RequestHeader (name = "Username") String username, @RequestBody MessagesDTO messagesDTO) {
        if (new UserAccounts().doesAccountExist(username)){
            messageService.addToMessageList(messagesDTO.toMessages());
        }
        else {
            throw new IllegalArgumentException();
        }
    }



}
