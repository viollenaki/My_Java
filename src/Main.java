import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }





        System.out.println(arrayList);
        arrayList.remove(0);
        arrayList.set(0,10);
        System.out.println(arrayList);


    }
}