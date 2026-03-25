import java.util.ArrayList;
import java.util.List;
public class TrainConsistManagementApp {
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===TrainConsistManagementApp===  ");
     System.out.println("======================================");
     List<String> passengerBogies = new ArrayList<>();
     passengerBogies.add("Sleeper");
     passengerBogies.add("AC Chair");
     passengerBogies.add("First class");
     System.out.print("After adding Bogies");
     System.out.print(passengerBogies);
     passengerBogies.remove("AC Chair");
     System.out.print("\nAfter Removing 'AC Chair' ");
     System.out.print(passengerBogies);
     boolean isSleeperPresent = passengerBogies.contains("Sleeper");
     System.out.println("\nIs 'Sleeper' bogie present? " + isSleeperPresent);
     System.out.println("\nFinal Passenger Bogie List:");
     System.out.println(passengerBogies);
     System.out.println("\nSystem ready for next operations...");
}
}
