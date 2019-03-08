package kafkaconsumer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class ConsumerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MessageService messageService;

    @Value(value = "${message.topic.name}")
    private String topicName;

    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "buc") //, groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void receiveMessage(String messageContent) {
        System.out.println("Received Messasge: " + messageContent);
        latch.countDown();
        messageService.addMessage(messageContent);
    }

}
