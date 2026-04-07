public class VIPUser extends RegisteredUsers {
    public VIPUser(String fullName, String emailAddress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, int cvv, String userType, String[] lastThreeTrips) {
        super(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, cvv, userType, lastThreeTrips);
    }

    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }
}
