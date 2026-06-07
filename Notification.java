import java.time.LocalDateTime;

public class Notification {
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;

    public Notification(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
        isRead = false; 
    }

    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public boolean isRead() { return isRead; }
    public void markAsRead() { isRead = true; }
}
