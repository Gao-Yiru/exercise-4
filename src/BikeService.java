import java.time.LocalDateTime;

public class BikeService {
    public String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (location.equals(bike.getLocation()) && bike.getIsAvailable()) {
                System.out.println("A bike is avaliable at the location you required.");
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requestes. Please try again later.");
        return null;
    }

    public void reserveBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Reserving the bike with the ID" + bikeID + ".Please follow the on-screen instructions to locate the bike and start your pleasant journey.");
                break;
            }
        }
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;

            }
        }
    }
    
}
