import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest extends TrainConsistManagementApp {

    @Test
    void testGroupBogies_SingleTypeSingleBogie() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(1, result.get("Sleeper").size());
        assertEquals(72, result.get("Sleeper").get(0).capacity);
    }

    @Test
    void testGroupBogies_MultipleDifferentTypes() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("General", 90)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(3, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("General"));
    }

    @Test
    void testGroupBogies_MultipleBogiesSameType() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 80),
                new TrainConsistManagementApp.Bogie("Sleeper", 64)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(3, result.get("Sleeper").size());
    }

    @Test
    void testGroupBogies_MixedTypesWithDuplicates() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56),
                new TrainConsistManagementApp.Bogie("Sleeper", 80),
                new TrainConsistManagementApp.Bogie("General", 90),
                new TrainConsistManagementApp.Bogie("AC Chair", 60)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(3, result.size());
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("General").size());
    }

    @Test
    void testGroupBogies_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGroupBogies_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        int originalSize = bogies.size();

        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("General", bogies.get(1).name);
    }
}