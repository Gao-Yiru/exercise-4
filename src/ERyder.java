public class ERyder {
   public static final String COMPANY_NAME = "ERyder";
   public static final double BASE_FARE = (double)1.0F;
   public static final double PER_MINUTE_FARE = (double)0.5F;
   private final String LINKED_ACCOUNT;
   private final String LINKED_PHONE_NUMBER;
   private int bikeID;
   private int batteryLevel;
   private boolean isAvailable;
   private double kmDriven;
   private int totalUsageInMinutes;
   private double totalFare;

   public ERyder(int var1, int var2, boolean var3, double var4) {
      this.bikeID = var1;
      this.batteryLevel = var2;
      this.isAvailable = var3;
      this.kmDriven = var4;
      this.LINKED_ACCOUNT = "default_user";
      this.LINKED_PHONE_NUMBER = "default_123456789";
   }

   public ERyder(int var1, int var2, boolean var3, double var4, String var6, String var7) {
      this.bikeID = var1;
      this.batteryLevel = var2;
      this.isAvailable = var3;
      this.kmDriven = var4;
      this.LINKED_ACCOUNT = var6;
      this.LINKED_PHONE_NUMBER = var7;
   }

   public void printRideDetails(int var1) {
      this.totalUsageInMinutes = var1;
      System.out.println("======= Ride Details =======");
      System.out.println("The linked account is " + this.LINKED_ACCOUNT + ".");
      System.out.println("The linked phone number is " + this.LINKED_PHONE_NUMBER + ".");
      System.out.println("The bike ID is " + this.bikeID + ".");
      System.out.println("The usage in minutes is " + this.totalUsageInMinutes + ".");
      System.out.println("The total fare is " + calculateFare(var1) + ".");
      System.out.println("============================\n");
   }

   public void printBikeDetails() {
      System.out.println("======= Bike Details =======");
      System.out.println("The bike's ID is " + this.bikeID + ".");
      System.out.println("The battery level is " + this.batteryLevel + "%.");
      if (this.isAvailable) {
         System.out.println("The bike is available.");
      } else {
         System.out.println("The bike is not available.");
      }

      System.out.println("The bike's distance travelled in " + this.kmDriven + " km.");
      System.out.println("============================\n");
   }

   private double calculateFare(int var1) {
      this.totalFare = (double)1.0F + (double)0.5F * (double)var1;
      return (double)1.0F + (double)0.5F * (double)var1;
   }

   public double getTotalFare() {
      return this.totalFare;
   }
}
