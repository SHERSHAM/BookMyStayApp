import java.util.HashMap;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 1);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);

        BookingValidator validator = new BookingValidator(inventory);

        String[] requests = {"Single Room", "Double Room", "Deluxe Room"};

        for (String roomType : requests) {

            try {
                validator.validate(roomType);
                System.out.println("Booking valid for: " + roomType);
            } catch (InvalidBookingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}