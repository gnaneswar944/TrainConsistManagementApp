import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // Method for filtering bogies by capacity threshold
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("   === UC 8 - Filter Bogies By Capacity ===");
        System.out.println("======================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        int threshold = 60;
        List<Bogie> filteredBogies = filterBogiesByCapacity(bogies, threshold);

        System.out.println("\nBogies with capacity > " + threshold + ":");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }
    }
}