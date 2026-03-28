import java.time.LocalDateTime;
public class ActiveRental {
    private String userEmail;
    private LocalDateTime tripStartTime;
    private String bikeID;
    public ActiveRental(String bikeID,String userEmail, LocalDateTime tripStartTime) {
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
        this.bikeID = bikeID;
    }

    public ActiveRental() { }
    
    public String getUserEmail() {
        return userEmail;
    }
    public String getBikeID() {
        return bikeID;
    }
    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }
    @Override
    public String toString(){
        return "Bike ID:"+bikeID+"\nUser Email:"+userEmail+"Last used time:"
            +tripStartTime;
    }
}
