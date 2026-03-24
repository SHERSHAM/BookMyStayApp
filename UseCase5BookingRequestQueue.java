import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("John", "Single Room"));
        bookingQueue.add(new Reservation("Alice", "Double Room"));
        bookingQueue.add(new Reservation("Bob", "Suite Room"));

        System.out.println("=== Booking Request Queue ===");

        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}