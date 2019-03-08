package kafkaconsumer.application;

import kafkaconsumer.domain.message.Message;
import kafkaconsumer.domain.message.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    private final AtomicLong counter = new AtomicLong();

    MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(String messageContent) {
        Message message = new Message(counter.incrementAndGet(), messageContent);
        this.messageRepository.add(message);
    }

    public Message getMessage(Long id) {
        return this.messageRepository.get(id);
    }

    public Collection<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }
}
