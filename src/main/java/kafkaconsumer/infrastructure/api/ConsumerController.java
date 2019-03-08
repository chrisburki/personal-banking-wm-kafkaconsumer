package kafkaconsumer.infrastructure.api;

import kafkaconsumer.application.MessageService;
import kafkaconsumer.domain.message.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final MessageService messageService;

    public ConsumerController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages().stream().collect(toList());
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public Message getMessage(@PathVariable("id") long id) {
        return messageService.getMessage(id);
    }
}

