import java.util.HashMap;

class BookingValidator {

    private HashMap<String, Integer> inventory;

    public BookingValidator(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void validate(String roomType) throws InvalidBookingException {

        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid Room Type: " + roomType);
        }

        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
        }
    }
}