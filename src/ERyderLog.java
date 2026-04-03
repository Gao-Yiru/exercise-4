import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ERyderLog {
    private String log;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String log, String event, LocalDateTime timeStamp) {
        this.log = log;
        this.event = event;
        this.timeStamp = timeStamp;

    }


    public String getLog() {
        return log;
    }

    public String gteEvent() {
        return event;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    @Override
    public String toString() {
        return log + " - " + event + " - " + timeStamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
}
