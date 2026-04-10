public class TrainConsistManagementApp {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie model with validation ----
    static class PassengerBogie {
        private String bogieType;
        private int capacity;

        public PassengerBogie(String bogieType, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid bogie capacity: Capacity must be greater than zero.");
            }
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public String getBogieType() {
            return bogieType;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return bogieType + " Bogie [Capacity = " + capacity + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("==============================================");

        try {
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Bogie created successfully: " + bogie1);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            PassengerBogie bogie2 = new PassengerBogie("AC Chair", -10);
            System.out.println("Bogie created successfully: " + bogie2);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            PassengerBogie bogie3 = new PassengerBogie("First Class", 0);
            System.out.println("Bogie created successfully: " + bogie3);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Program continues safely after exception handling.");
    }
}