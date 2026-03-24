public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "R101";

        manager.addService(reservationId, new AddOnService("Breakfast", 20));
        manager.addService(reservationId, new AddOnService("WiFi", 10));
        manager.addService(reservationId, new AddOnService("Airport Pickup", 30));

        manager.displayServices(reservationId);

        double total = manager.calculateTotalCost(reservationId);

        System.out.println("Total Add-On Cost: $" + total);
    }
}