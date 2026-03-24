import java.io.*;
import java.util.*;

class SystemState implements Serializable {

    HashMap<String, Integer> inventory;
    List<Reservation> history;

    public SystemState(HashMap<String, Integer> inventory, List<Reservation> history) {
        this.inventory = inventory;
        this.history = history;
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        String file = "system.dat";

        HashMap<String, Integer> inventory = new HashMap<>();
        List<Reservation> history = new ArrayList<>();

        File f = new File(file);

        if (f.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                SystemState state = (SystemState) in.readObject();
                inventory = state.inventory;
                history = state.history;
                in.close();

                System.out.println("Data loaded from file");
            } catch (Exception e) {
                System.out.println("Error loading data");
            }
        } else {
            inventory.put("Single Room", 2);
            inventory.put("Double Room", 1);

            history.add(new Reservation("John", "Single Room"));
            history.add(new Reservation("Alice", "Double Room"));

            System.out.println("New data initialized");
        }

        System.out.println("\nInventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nBooking History:");
        for (Reservation r : history) {
            System.out.println(r);
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(new SystemState(inventory, history));
            out.close();

            System.out.println("\nData saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }
}
