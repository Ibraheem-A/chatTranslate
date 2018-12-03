package translate.useCases.messaging;

import java.util.Objects;

public class Messages {
    private final String message;


    public Messages (String message){
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messages messages = (Messages) o;
        return Objects.equals(message, messages.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
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
