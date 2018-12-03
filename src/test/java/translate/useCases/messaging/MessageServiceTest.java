package translate.useCases.messaging;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MessageServiceTest {



    @Test
    public void serviceShouldBeAbleToAddOneMessage(){
        Messages messages = new Messages("Hallo");
        MessageService messageService = new MessageService();
        messageService.addToMessageList(messages);

        assertThat(messageService.getMessages()).containsExactly(messages);

    }


}