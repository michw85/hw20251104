package app.Exception;

import java.util.List;

public class NotCorrectEmailFormatException extends RuntimeException {
    private List<String> list;
    public NotCorrectEmailFormatException(String message) {
        super(message);
    }
    public NotCorrectEmailFormatException(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }
}
