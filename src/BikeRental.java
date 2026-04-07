import java.time.LocalDateTime;
import java.util.Scanner;

public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    private RegisteredUsers currentUser;
    private BikeService bikeService = new BikeService();
    private RentalService rentalService;

    public BikeRental(RegisteredUsers user) {
        this.currentUser = user;
        this.rentalService = new RentalService(bikeService);
        this.rentalService.setCurrentUser(user);
    }

    public void simulateApplicationInput() {
        System.out.println("This is the simulation of the e-bike rental process.");
        Scanner sc = new Scanner(System.in);

        if (currentUser != null) {
            isRegisteredUser = true;
            emailAddress = currentUser.getEmailAddress();
            System.out.println("Welcome back, " + emailAddress + "!");
        } else {
            System.out.print("Are you a registered user? (true/false): ");
            isRegisteredUser = sc.nextBoolean();
            sc.nextLine();
            System.out.print("Enter your email: ");
            emailAddress = sc.nextLine();
        }

        System.out.print("Enter desired location: ");
        location = sc.nextLine();

        System.out.println("Simulating the analysis of the rental request.");
        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);
        if (!locationValid) {
            sc.close();
            return;
        }

        System.out.println("Simulating e-bike reservation…");
        rentalService.startRental(bikeID, emailAddress, location);
        rentalService.viewActiveRentals();

        System.out.println("Simulating the end of the trip…");
        rentalService.endRental(bikeID);
        System.out.println("Displaying the active rentals after trip end…");
        rentalService.viewActiveRentals();
        sc.close();
    }

    private String analyseRequest(boolean isRegistered, String emailAddress, String location) {
        if (!isRegistered) {
            System.out.println("You’re not our registered user. Please consider registering.");
            // 可以调用 UserRegistration 进行注册，但为简洁，直接返回 null
            return null;
        }
        return validateLocation(location);
    }

    private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (location.equals(bike.getLocation()) && bike.getIsAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }
}