import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    UserRegistration userRegistration = new UserRegistration();
    ActiveRental activeRental = new ActiveRental();
    LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    public void simulateApplicationInput(){
        System.out.println("This is the simulation of the e-bike rental process.");
        Scanner sc = new Scanner(System.in);
        isRegisteredUser = sc.nextBoolean();
        sc.nextLine();
        emailAddress = sc.nextLine();
        location = sc.nextLine();
        System.out.println("Simulating the analysis of the rental request.");
        bikeID = analyseRequest(isRegisteredUser,emailAddress,location);
        if(!locationValid)
        {
            sc.close();
            return;
        }
        System.out.println("Simulating e-bike reservation…");
        reverseBike(bikeID);
        viewActiveRentals();
        System.out.println("Simulating the end of the trip…");
        removeTrip(bikeID);
        System.out.println("Displaying the active rentals after trip end…");
        viewActiveRentals();
        sc.close();

    }
    private String analyseRequest(boolean isRegistered,String emailAddress,String location){
        if(isRegistered)System.out.println("Welcome back, "+emailAddress+"!");
        else{
            System.out.println(" You’re not our registered user. Please consider registering.");
            userRegistration.registration();
            
        }
        return validateLocation(location);
    }
    private String validateLocation(String location){
        for(Bike bike : BikeDatabase.bikes){
            if(location.equals(bike.getLocation()) && bike.getIsAvailable()){
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }

        }
        System.out.println("Sorry, no bikes are available at the location you" + 
                        "requested. Please try again later.");
        return null;
    }
    private void reverseBike(String bikeID){
        if(bikeID!=null){
            for(Bike bike:BikeDatabase.bikes){
                if(bikeID.equals(bikeID))tripStartTime = LocalDateTime.now();
                bike.setIsAvailable(false);
                bike.setLastUsedTime(tripStartTime);
                System.out.println(" Reserving the bike with the (bikeID). Please following the on-screen instructions." + 
                                        "to locate the bike and start your pleasant journey.");
                ActiveRental activeRental = new ActiveRental(bikeID,emailAddress,tripStartTime);
                activeRentalsList.add(activeRental);
                break;
            }
        }
        else{
            System.out.println(" Sorry, we’re unable to reserve a bike at this time. Please try again later.");
        }
    }
    private void viewActiveRentals(){
        if(activeRentalsList.isEmpty())System.out.println("No active rentals at the moment.");
        else {
            for(ActiveRental activeRental:activeRentalsList){
                System.out.println(activeRental);
            }
        }
    }
    private void removeTrip(String bikeID){
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while(iterator.hasNext()){
            ActiveRental rental = iterator.next();
            if(rental.getBikeID().equals(bikeID)){
                iterator.remove();
                break;
            }
        }
        Iterator<Bike>iterator2 = BikeDatabase.bikes.iterator();
        while(iterator2.hasNext()){
            Bike bike = iterator2.next();
            if(bike.getBikeID().equals(bikeID)){
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }

}
