import java.util.*;
import java.util.List;
public class TrainConsistManagementApp {
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===Maintain Ordered Bogie Consist ===  ");
     System.out.println("======================================");
     List<String> trainConsist = new LinkedList<>();
     trainConsist.add("Engine");
     trainConsist.add("Sleeper");
     trainConsist.add("AC");
     trainConsist.add("Cargo");
     trainConsist.add("Guard");
     System.out.print("Intial Train Consist\n");
     System.out.print(trainConsist);
     trainConsist.set(2, "Pantry Car");
     System.out.print("\nAfter Inserting 'pantry Car' at position 2\n");
     System.out.print(trainConsist);
     trainConsist.remove("Sleeper");
     trainConsist.remove("Guard");
     System.out.print("\nAfter removing first and last\n");
     System.out.print(trainConsist);
}
}
