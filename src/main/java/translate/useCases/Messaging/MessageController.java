package translate.useCases.Messaging;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import translate.useCases.userAccount.UserAccountService;
import translate.useCases.userAccount.UserAccounts;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MessageController {

    MessageService messageService = new MessageService();

    @RequestMapping(path = "messages", method = RequestMethod.GET)
    public List<MessagesDTO> getMessages(@RequestHeader HttpHeaders headers) {
        List <String> userHeaders = headers.get("Username");
        if (userHeaders == null || userHeaders.size() != 1){
            throw new IllegalArgumentException();
        } else if (new UserAccounts().doesAccountExist(userHeaders.get(0))) {
            return messageService.getMessages()
                    .stream()
                    .map(MessagesDTO::from)
                    .collect(Collectors.toList());
        }
        else {
            return Collections.emptyList();
        }
    }


    @RequestMapping(path = "messages", method = RequestMethod.POST)
    public void composeMessages(@RequestBody MessagesDTO messagesDTO) {
        messageService.addToMessageList(messagesDTO.toMessages());

    }



}
