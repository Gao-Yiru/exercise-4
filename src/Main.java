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

 
        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";

        Feedback feedBack = new Feedback("Alice", "Beauty", "4923das@163.com");
        feedBack.analyseFeedBack(false, sent1, sent2, sent3, sent4, sent5); 
        System.out.println(feedBack);

        UserRegistration userReg = new UserRegistration();
        userReg.registration();
        System.out.println("\n" + userReg);
    }
    
}
