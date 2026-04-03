import java.time.LocalDateTime;
import java.util.*;

public class SystemManager {
    public static Stack<ERyderLog> systemLogs = new Stack<>();
    public static Queue<BikeRequest> bikeRequestQueue = new ArrayDeque<>();
    public static void addLog(String logId, String eventDescription) {
        ERyderLog logEntry = new ERyderLog(logId, eventDescription, LocalDateTime.now()); 
        systemLogs.push(logEntry);
    }

    public static void addBikeRequest(String userEmail, String location) {
        BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
        bikeRequestQueue.offer(request);
        System.out.println("Bike not available. Request added to the queue.");
    }

    public static void viewSystemLogs() {
        if (systemLogs.isEmpty()) {
            System.out.println("No system logs available.");
            return;
        }
        System.out.println("\n========== SYSTEM LOGS ==========");
        for (int i = systemLogs.size() - 1; i >= 0; i--) {
            System.out.println(systemLogs.get(i));
        }
        System.out.println("========================================\n");
    }

    public static void processNextRequest(BikeService bikeService, String availableBikeID, String availableLocation) {
        if (bikeRequestQueue.isEmpty()) return;

        BikeRequest nextRequest = bikeRequestQueue.poll();
        System.out.println("\n--- Processing pending request from " + nextRequest.getUserEmail() + " ---");
        bikeService.reserveBike(availableBikeID, nextRequest.getUserEmail(), nextRequest.getLocation());
    }
    
}
