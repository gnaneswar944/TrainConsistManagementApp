import java.util.*;
import java.util.List;
public class TrainConsistManagementApp {
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===Track Unique Bogie IDs ===  ");
     System.out.println("======================================");
     Set<String> bogieIDs = new HashSet<>();
     bogieIDs.add("BG104");
     bogieIDs.add("BG103");
     bogieIDs.add("BG102");
     bogieIDs.add("BG101");
     System.out.print("Bogie IDs AFter Insertion:\n");
     System.out.print(bogieIDs);
}
}
