import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest extends TrainConsistManagementApp {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingLoop(bogies, 50);

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(bogies, 50);

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterUsingLoop(bogies, 50);

        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterUsingStream(bogies, 50);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        }

        long start = System.nanoTime();
        TrainConsistManagementApp.filterUsingLoop(bogies, 50);
        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("General", 90));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(bogies, 50);

        assertEquals(10000, result.size());
    }
}