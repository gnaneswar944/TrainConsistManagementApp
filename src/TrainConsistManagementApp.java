import java.util.*;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {
    static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("\n UC11 : Validate Train ID and Cargo CODES(Redgex)\n");
        System.out.println("============================================================");
        System.out.print("Enter Train ID (Format : TRN-1234): ");
        String trainID = scanner.nextLine();
        System.out.print("Enter Cargo CODE (Format : PET-AB): ");
        String cargoCode = scanner.nextLine();
        boolean isTrainValid = Pattern.matches(TRAIN_ID_REGEX, trainID);
        boolean isCargoValid = Pattern.matches(CARGO_CODE_REGEX, cargoCode);
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);
        System.out.println("\nUC11 validation completed...");

    }


    }
