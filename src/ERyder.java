public class ERyder {
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;


    private int bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

   
    
    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "default_user";
        this.LINKED_PHONE_NUMBER = "default_123456789";
    }

    public ERyder(int bikeID, int batteryLevel, boolean isAvailable, double kmDriven, String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        this.batteryLevel = batteryLevel;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    public void printRideDetails(int usageInMinutes){
        totalUsageInMinutes = usageInMinutes;
        System.out.println("======= Ride Details =======");
        System.out.println("The linked account is "+LINKED_ACCOUNT+".");
        System.out.println("The linked phone number is "+LINKED_PHONE_NUMBER+".");
        System.out.println("The bike ID is "+bikeID+".");
        System.out.println("The usage in minutes is "+totalUsageInMinutes+".");
        System.out.println("The total fare is "+calculateFare(usageInMinutes)+".");
        System.out.println("============================\n");
    }


    public void printBikeDetails(){
        System.out.println("======= Bike Details =======");
        System.out.println("The bike's ID is " + bikeID+".");
        System.out.println("The battery level is " + batteryLevel+"%.");
        if(isAvailable){System.out.println("The bike is available.");}
        else {System.out.println("The bike is not available.");}
        System.out.println("The bike's distance travelled in " + kmDriven + " km.");
        System.out.println("============================\n");
    }

    private double calculateFare(int usageInMinutes) {
        totalFare = BASE_FARE + (PER_MINUTE_FARE*usageInMinutes);
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }


    public double getTotalFare() {
        return totalFare;
    }   
   

    
}




