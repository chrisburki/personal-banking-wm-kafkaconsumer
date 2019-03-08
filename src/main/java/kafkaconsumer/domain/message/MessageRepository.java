package kafkaconsumer.domain.message;

import java.util.Collection;

public interface MessageRepository {
    void add(Message message);

    Message get(Long id);

    Collection<Message> findAll();
}
