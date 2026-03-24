import java.util.*;

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("John", "Single Room"));
        queue.add(new Reservation("Alice", "Double Room"));
        queue.add(new Reservation("Bob", "Suite Room"));
        queue.add(new Reservation("David", "Single Room"));

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());
        allocatedRooms.put("Suite Room", new HashSet<>());

        System.out.println("=== Room Allocation ===");

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();
            String type = r.getRoomType();

            int available = inventory.getOrDefault(type, 0);

            if (available > 0) {

                int count = allocatedRooms.get(type).size() + 1;
                String prefix = type.startsWith("Single") ? "S" :
                                type.startsWith("Double") ? "D" : "SU";

                String roomId = prefix + count;

                allocatedRooms.get(type).add(roomId);
                inventory.put(type, available - 1);

                System.out.println("Confirmed: " + r.getGuestName() +
                        " -> " + type + " | Room ID: " + roomId);

            } else {
                System.out.println("Rejected: " + r.getGuestName() +
                        " -> No " + type + " available");
            }
        }

        System.out.println("\nRemaining Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}