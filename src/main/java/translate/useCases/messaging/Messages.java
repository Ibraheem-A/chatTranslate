package translate.useCases.messaging;

import java.util.Objects;

public class Messages {
    private final String message;
    private final String sender;

    public Messages (String message, String sender){
        this.message = message;
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messages messages = (Messages) o;
        return Objects.equals(message, messages.message) &&
                Objects.equals(sender, messages.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, sender);
    }

    @Override
    public String toString() {
        return "Messages{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return this.message;
    }
}
