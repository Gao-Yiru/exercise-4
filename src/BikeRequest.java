import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BikeRequest {
    private String userEmail;
    private String location;
    private LocalDateTime requestTime;

    public BikeRequest(String userEmail, String location, LocalDateTime requestTime) {
        this.userEmail = userEmail;
        this.location = location;
        this.requestTime = requestTime;
    }
    public String getLocation() {
        return location;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return userEmail + " requested a bike at " + location + " on " + requestTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public String getUserEmail() {
        return userEmail;
    }

}
