import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class TrainConsistManagementApp {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (" + capacity + " seats)";
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int minCapacity) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.capacity >= minCapacity) {
                result.add(bogie);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int minCapacity) {
        return bogies.stream()
                .filter(bogie -> bogie.capacity >= minCapacity)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=================================================\n");

        // Create large test dataset
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            if (i % 4 == 0) {
                bogies.add(new Bogie("Sleeper", 72));
            } else if (i % 4 == 1) {
                bogies.add(new Bogie("AC Chair", 56));
            } else if (i % 4 == 2) {
                bogies.add(new Bogie("First Class", 24));
            } else {
                bogies.add(new Bogie("General", 90));
            }
        }

        int minCapacity = 50;

        // Measure loop execution time
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies, minCapacity);
        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // Measure stream execution time
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies, minCapacity);
        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // Display results
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        System.out.println();

        System.out.println("Loop Filtered Bogies Count   : " + loopResult.size());
        System.out.println("Stream Filtered Bogies Count : " + streamResult.size());
        System.out.println();

        System.out.println("UC13 performance benchmarking completed...");
    }
}