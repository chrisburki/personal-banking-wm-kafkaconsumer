package kafkaconsumer.domain.message;

public class Message {
    private final long id;
    private final String content;

    public Message(long id, String name) {
        this.id = id;
        this.content = name;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
