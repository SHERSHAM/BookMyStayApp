import java.util.*;

class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);
    }

    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());

        for (AddOnService s : services) {
            total += s.getCost();
        }

        return total;
    }

    public void displayServices(String reservationId) {

        List<AddOnService> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());

        System.out.println("Services for " + reservationId + ":");

        for (AddOnService s : services) {
            System.out.println(s);
        }
    }
}