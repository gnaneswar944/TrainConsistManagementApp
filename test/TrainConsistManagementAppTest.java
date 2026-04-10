import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest extends TrainConsistManagementApp {

    @Test
    void testTotalCapacity_NormalCase() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(152, result);
    }

    @Test
    void testTotalCapacity_EmptyList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(0, result);
    }

    @Test
    void testTotalCapacity_SingleBogie() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(72, result);
    }

    @Test
    void testTotalCapacity_MultipleSameType() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(142, result);
    }

    @Test
    void testTotalCapacity_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(1, bogies.size());
    }
}