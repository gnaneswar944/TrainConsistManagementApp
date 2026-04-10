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
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;
public class TrainConsistManagementAppTest extends TrainConsistManagementApp {
    static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(TRAIN_ID_REGEX, "TRN-6524"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRAIN12"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(CARGO_CODE_REGEX, "PET-FH"));
    }



    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "pet-12"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRN-123"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, ""));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertTrue(Pattern.matches(TRAIN_ID_REGEX, "TRN-0001"));
        assertTrue(Pattern.matches(CARGO_CODE_REGEX, "PET-XY"));
    }
}