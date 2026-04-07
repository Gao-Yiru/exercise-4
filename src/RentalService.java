import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class RentalService {
    public static final double BASE_FARE = 3.0;   

    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private BikeService bikeService;
    private RegisteredUsers currentUser; 

    public RentalService(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    public void setCurrentUser(RegisteredUsers user) {
        this.currentUser = user;
    }

    public void startRental(String bikeID, String userEmail, String location) {
        if (bikeID != null) {
            LocalDateTime tripStart = LocalDateTime.now();
            ActiveRental activeRental = new ActiveRental(bikeID, userEmail, tripStart);
            activeRentalsList.add(activeRental);
            bikeService.reserveBike(bikeID, userEmail, location);
        } else {
            System.out.println("Sorry, we're unable to reserve a bike at this time. Please try again later.");
        }
    }

    public void endRental(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }
        bikeService.releaseBike(bikeID);

      
        if (currentUser != null) {
            double fare = currentUser.calculateFare(BASE_FARE);
            System.out.printf("Trip fare: €%.2f (after any discount)%n", fare);
            currentUser.displayUserType();
        } else {
            System.out.println("No user information available for fare calculation.");
        }
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    public void cancelRental(String bikeID) {
        endRental(bikeID);
        System.out.println("Rental cancelled.");
    }
}