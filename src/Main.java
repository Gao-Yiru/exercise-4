public  class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder(1001, 85, true, 125.6);
        bike1.printBikeDetails();
        bike1.printRideDetails(10);

        ERyder bike2 = new ERyder(1002, 42, false, 289.3, "user_007", "9876543210");
        bike2.printBikeDetails();
        bike2.printRideDetails(30);
        System.out.println("Correct usage of private method calculateFare(): Called internally via public method printBikeDetails.");
        System.out.println("Total fare for bike1 (10 minutes ride):" + bike1.getTotalFare());
        System.out.println("Total fare for bike2 (25 minutes ride):" + bike2.getTotalFare() + "USD");
    }
    
}
