import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BikeService {
    private Deque<ERyderLog> systemLogs = new ArrayDeque<>();
    //Queue<BikeRequest>bikeRequest = new ArrayDeque<>();
    public void reserveBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Reserving the bike with the ID " + bikeID + ". Please follow the on-screen instructions to locate the bike and start your pleasant journey.");
                break;
            }
        }
    }
        

    public void reserveBike(String bikeID, String userEmail, String location) {
        Bike targetBike = null;
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                targetBike = bike;
                break;
            }
        }
        if (targetBike != null && targetBike.getIsAvailable()) {
            targetBike.setIsAvailable(false);
            targetBike.setLastUsedTime(LocalDateTime.now());
            targetBike.setLocation(location);
            System.out.println("Reserving the bike with the ID " + bikeID + ". Please follow the on-screen instructions to locate the bike and start your pleasant journey.");

            String rentLogId = "RENT-" + bikeID;
            String rentEvent = "Bike " + bikeID + " was rented by " + userEmail + " from " + location;
            SystemManager.addLog(rentLogId, rentEvent);

            String startLogId = "START-" + bikeID;
            String startEvent = "Trip started with bike " + bikeID + " by " + userEmail + " at " + location;
            SystemManager.addLog(startLogId, startEvent);
        } else {
            SystemManager.addBikeRequest(userEmail, location);
        }
        
    }

    public void releaseBike(String bikeID) {
        Bike releasedBike = null;
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                releasedBike = bike;
                break;

            }
        }

        if (releasedBike != null) {
            releasedBike.setIsAvailable(true);
            releasedBike.setLastUsedTime(LocalDateTime.now());

            String endLogId = "END-" + bikeID;
            String endEvent = "Trip ended with bike " + bikeID;
            SystemManager.addLog(endLogId, endEvent);

            System.out.println("Your trip has ended. Thank you for riding with us.");
            String currentLocation = releasedBike.getLocation();
            SystemManager.processNextRequest(this, bikeID, currentLocation);
        }
    } 
    public void viewSystemLogs(){
        for(ERyderLog eRyderLog : SystemManager.systemLogs){
            System.out.println(eRyderLog);
        }
    }
}
