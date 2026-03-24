import java.util.*;

class BookingReportService {

    public void displayAllBookings(List<Reservation> history) {

        System.out.println("=== Booking History ===");

        for (Reservation r : history) {
            System.out.println(r);
        }
    }

    public void totalBookings(List<Reservation> history) {
        System.out.println("Total Bookings: " + history.size());
    }
}