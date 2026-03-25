import java.util.*;
import java.util.List;
public class TrainConsistManagementApp {
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===UC 6-MAP Bogie to Capacity ===  ");
     System.out.println("======================================");
     Map<String, Integer> capacityMap = new HashMap<>();
     capacityMap.put("First Class",24);
     capacityMap.put("Cargo",120);
     capacityMap.put("Sleeper",72);
     capacityMap.put("AC Chair",56);
     for (Map.Entry<String, Integer> entry : capacityMap.entrySet()){
         System.out.println(entry.getKey() + "->"+entry.getValue());
     }

}
}
