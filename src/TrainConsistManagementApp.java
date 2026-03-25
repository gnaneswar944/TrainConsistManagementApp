import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {
    static class Bogie{
        String name;
        int capacity;
        Bogie(String name, int capacity){
            this.name = name;
            this.capacity = capacity;

        }

        @Override
        public String toString(){
            return name + "("+capacity+"seats)";
        }
    }
 public static void main(String[] args){
     System.out.println("======================================");
     System.out.println("   ===UC 7-Sort Bogies BY Capacity ===  ");
     System.out.println("======================================");
     List<Bogie> bogies = new ArrayList<>();
     bogies.add(new Bogie("Sleeper\n",72));
     bogies.add(new Bogie("\nAC Chair\n",56));
     bogies.add(new Bogie("\nFirst Class\n",24));
     bogies.add(new Bogie("\nGeneral\n",90));
     System.out.print("ALL Bogies\n");
     for (Bogie b : bogies){

         System.out.print(b);
     }
     List<Bogie> filteredBogies = bogies.stream()
             .filter(b -> b.capacity >60)
             .collect(Collectors.toList());
     System.out.println("\nBogies with capacity > 60 :");
     for (Bogie filteredBogy : filteredBogies) {
         System.out.print(filteredBogy);
     }
 }
}
