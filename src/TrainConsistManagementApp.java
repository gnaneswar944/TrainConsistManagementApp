import java.util.ArrayList;
import java.util.List;
public class TrainConsistManagementApp {
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===TrainConsistManagementApp===  ");
     System.out.println("======================================");
     List<String> trainConsist = new ArrayList<>();
     System.out.println("Train intialized successfully");
     System.out.print("Intial Boggie count: "+trainConsist.size());
     System.out.println("\nCurrent Train Consist : " + trainConsist);
     System.out.println("\nSystem ready for operations...");
 }
}
