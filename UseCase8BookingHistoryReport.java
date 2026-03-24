public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();
        BookingReportService report = new BookingReportService();

        history.addReservation(new Reservation("John", "Single Room"));
        history.addReservation(new Reservation("Alice", "Double Room"));
        history.addReservation(new Reservation("Bob", "Suite Room"));

        report.displayAllBookings(history.getHistory());
        report.totalBookings(history.getHistory());
    }
}