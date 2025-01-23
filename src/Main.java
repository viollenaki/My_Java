import java.util.Arrays;
import java.util.Random;

public class Main {
    public static String get_arr_Sum_Average_Smallest(){

        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i<10; i++){
            arr[i] = rand.nextInt(100);
        }
        float sum = 0;
        float counter = 0;
        float smallest= Float.POSITIVE_INFINITY;
        float largest = Float.NEGATIVE_INFINITY;
        float secondLargest =  Float.NEGATIVE_INFINITY;
        float secondSmallest= Float.POSITIVE_INFINITY;
        for (int i : arr){
        if (i > largest) {
            secondLargest = largest;  // Update secondLargest before largest
            largest = i;
        } else if (i > secondLargest && i != largest) {
            secondLargest = i;
        }
    
        if (i < smallest) {
            secondSmallest = smallest;  // Update secondSmallest before smallest
            smallest = i;
        } else if (i < secondSmallest && i != smallest) {
            secondSmallest = i;
        }
    }
        
        return "average= "+sum/counter + "\nsum= " + sum + "\n largest= " + largest + "\n smallest= " + smallest + "\n second largest= " + secondLargest + "\n second smallest= "  +secondSmallest + "\n" + Arrays.toString(arr);
    }

    public static Boolean if_recoursive(Object v){
        String var = v.toString();
        if (var.length()==1 | var.length()==0){
            return true;
        }
        if (var.charAt(0)==var.charAt(var.length() - 1)){
            var = var.substring(1, var.length()-1);
            return if_recoursive(var);
        }
        else{
            return false;
        }

    }








    public static void main(String[] args) {
        System.out.println(get_arr_Sum_Average_Smallest());
        System.out.println(if_recoursive(122));
    }
    
}
