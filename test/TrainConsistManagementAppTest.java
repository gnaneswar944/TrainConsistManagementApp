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