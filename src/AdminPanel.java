import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    private List<RegisteredUsers> registeredUsers = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService(); 

    public void userManagementOptions() {
        System.out.println("Welcome to E-Ryder Administrator Panel.");
        System.out.println("What do you want to do?");
        System.out.println("1. Add New Users");
        System.out.println("2. View Registered Users");
        System.out.println("3. Remove Registered Users");
        System.out.println("4. Update Registered Users");
        System.out.println("5. View System Logs");
        System.out.println("6. Manage Pending Bike Requests");
        System.out.println("7. EXIT");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                
                RegisteredUsers newUser = userService.addNewUsers();
                if (newUser != null) {
                    System.out.println("\nProceeding to bike rental simulation with the newly created user...");
                    BikeRental bikeRental = new BikeRental(newUser);
                    bikeRental.simulateApplicationInput();
                } else {
                    System.out.println("No user was created. Returning to main menu.");
                }
                break;
            case 2:
                userService.viewRegisteredUSers();
                break;
            case 3:
                userService.removeRegisteredUsers();
                break;
            case 4:
                userService.updateregisteredUsers();
                break;
            case 5:
                SystemManager.viewSystemLogs();
                break;
            case 6:
                managePendingRequests();
                break;
            case 7:
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

  
    private void managePendingRequests() {
        int subChoice;
        do {
            System.out.println("\n--- Manage Pending Bike Requests ---");
            System.out.println("1. View Queue");
            System.out.println("2. Update Queue (remove first request)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    viewQueue();
                    break;
                case 2:
                    updateQueue();
                    break;
                case 3:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (subChoice != 3);
    }

    private void viewQueue() {
        if (SystemManager.bikeRequestQueue.isEmpty()) {
            System.out.println("No pending bike requests.");
            return;
        }
        System.out.println("\n===== PENDING BIKE REQUESTS =====");
        int index = 1;
        for (BikeRequest req : SystemManager.bikeRequestQueue) {
            System.out.println(index++ + ". " + req);
        }
        System.out.println("==================================\n");
    }

    private void updateQueue() {
        if (SystemManager.bikeRequestQueue.isEmpty()) {
            System.out.println("No pending requests to remove.");
            return;
        }
        BikeRequest removed = SystemManager.bikeRequestQueue.poll();
        System.out.println("Removed request: " + removed);
        System.out.println("Remaining pending requests: " + SystemManager.bikeRequestQueue.size());
    }
}