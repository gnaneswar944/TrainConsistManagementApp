import java.util.*;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)      // Extract capacity
                .reduce(0, Integer::sum);  // Sum all
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   === UC10 - Total Seat Count ===   ");
        System.out.println("======================================");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        int totalCapacity = calculateTotalCapacity(bogies);

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);
    }
}