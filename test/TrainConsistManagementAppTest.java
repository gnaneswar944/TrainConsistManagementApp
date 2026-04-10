import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest extends TrainConsistManagementApp {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertNotNull(bogie);
        assertEquals("Sleeper", bogie.getBogieType());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC Chair", -10)
        );

        assertEquals("Invalid bogie capacity: Capacity must be greater than zero.", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("First Class", 0)
        );

        assertEquals("Invalid bogie capacity: Capacity must be greater than zero.", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        TrainConsistManagementApp.InvalidCapacityException exception =
                new TrainConsistManagementApp.InvalidCapacityException(
                        "Invalid bogie capacity: Capacity must be greater than zero."
                );

        assertEquals("Invalid bogie capacity: Capacity must be greater than zero.", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie =
                new TrainConsistManagementApp.PassengerBogie("General", 90);

        assertAll(
                () -> assertEquals("General", bogie.getBogieType()),
                () -> assertEquals(90, bogie.getCapacity())
        );
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie1 =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        TrainConsistManagementApp.PassengerBogie bogie2 =
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 56);

        TrainConsistManagementApp.PassengerBogie bogie3 =
                new TrainConsistManagementApp.PassengerBogie("First Class", 24);

        assertNotNull(bogie1);
        assertNotNull(bogie2);
        assertNotNull(bogie3);

        assertEquals(72, bogie1.getCapacity());
        assertEquals(56, bogie2.getCapacity());
        assertEquals(24, bogie3.getCapacity());
    }
}