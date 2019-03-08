package kafkaconsumer.infrastructure.persistence;

import kafkaconsumer.domain.message.Message;
import kafkaconsumer.domain.message.MessageRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryMessageRepository implements MessageRepository {
    private final Map<Long, Message> messageMap;

    InMemoryMessageRepository() {
        messageMap = new HashMap<>();
    }

    @Override
    public void add(Message message) {
        this.messageMap.put(message.getId(),message);
    }

    @Override
    public Message get(Long id) {
        Message message = this.messageMap.get(id);
        if (message == null) {
            throw new RuntimeException("In Memory Message not exists");
        }

        return message;
    }

    @Override
    public Collection<Message> findAll() {
        return this.messageMap.values();
    }
}
