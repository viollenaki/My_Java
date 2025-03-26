
import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.xml.transform.Source;

public class Main {

    public static boolean isEmpty(ArrayList<Integer> list) {
        return list.isEmpty();
    }

    public static void replaceSecond(ArrayList<Integer> list, int value) {
        if (list.size() > 1) {
            list.set(1, value);
        }
    }

    public static ArrayList<Integer> cloneArr(ArrayList<Integer> list) {
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        return list2;
    }

    public static void removeThird(ArrayList<Integer> list) {
        if (list.size() > 2) {
            list.remove(2);
        }
    }

    public static boolean searchElement(ArrayList<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> convertToArrayList(LinkedList<Integer> list) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public static LinkedList<Integer> getUnique(LinkedList<Integer> list) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (hm.containsKey(list.get(i))) {
                hm.put(list.get(i), hm.get(list.get(i)) + 1);
            } else {
                hm.put(list.get(i), 1);
            }
        }
        LinkedList<Integer> uniqueList = new LinkedList<>();
        for (Integer key : hm.keySet()) {
            if (hm.get(key) == 1) {
                uniqueList.add(key);
            }
        }
        return uniqueList;
    }

    public static <T> T getFirst(LinkedList<T> list) {
        return list.get(0);
    }

    public static TreeSet<Integer> less7(TreeSet<Integer> hs) {
        TreeSet<Integer> less7 = new TreeSet<>();
        for (int i = 0; i < hs.size(); i++) {
            if (i < 7) {
                less7.add(i);
            }
        }
        return less7;
    }

    public static <T> int getSize(HashSet<T> hs) {
        int size = 0;
        for (int i = 0; i < hs.size(); i++) {
            size += 1;
        }
        return size;
    }

    public static TreeSet<Integer> getSimilar(TreeSet<Integer> hs1, TreeSet<Integer> hs2) {
        TreeSet<Integer> fin = new TreeSet<>();
        for (Integer element : hs1) {
            if (hs2.contains(element)) {
                fin.add(element);
            }
        }
        return fin;
    }

    public static <T> TreeSet<T> reversedSet(TreeSet<T> s) {
        TreeSet<T> newS = new TreeSet<>((a, b) -> -1 * a.toString().compareTo(b.toString()));
        newS.addAll(s);
        return newS;
    }

    public static TreeSet<Integer> allLower(TreeSet<Integer> s, int target) {
        TreeSet<Integer> sd = new TreeSet<>();
        for (Integer i : s) {
            if (i < target) {
                sd.add(i);
            }
        }
        return sd;
    }

    public static void main(String[] args) {
        //1
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = list.size() - 1; i > -1; i--) {
            list2.add(list.get(i));
        }
        System.out.println(list2);

        //2
        Main.replaceSecond(list, 3);
        //3
        System.out.println(Main.isEmpty(list));
        //4
        System.out.println(Main.cloneArr(list));
        //5
        Main.removeThird(list);
        //6
        System.out.println(Main.searchElement(list, 3));

        //New section
        //7
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(3);

        //8
        Integer a = ll.poll();
        System.out.println(a);
        System.out.println(ll.pollFirst());

        //9
        LinkedList<Integer> ll2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(Main.convertToArrayList(ll2));

        //10
        LinkedList<Integer> ll3 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
        ll3.removeFirst();
        ll3.removeLast();
        for (int i = 0; i < ll3.size(); i++) {
            ll3.remove(i);
        }

        //11
        LinkedList<Integer> ll4 = new LinkedList<>(Arrays.asList(1, 2, 3, 12, 32, 2, 65, 56, 34, 32, 2, 34, 1, 132, 413, 54, 65, 685, 8, 65, 54, 43, 1, 235, 34));
        System.out.println(Main.getUnique(ll4).toString());
        System.out.println(ll4.isEmpty());

        //12
        System.out.println(Main.getFirst(ll4));

        //New section
        //13
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 234, 43));
        hs.removeAll(hs);
        System.out.println(hs.toString());

        //14
        TreeSet<Integer> hs2 = new TreeSet<>(Arrays.asList(234, 123, 76, 786, 325, 132, 75, 64, 1, 76, 234, 36, 45, 46, 54, 2, 5, 32, 325, 45, 4));
        System.out.println(Main.less7(hs2));

        //15
        Main.getSize(hs);

        //16
        TreeSet<Integer> h = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeSet<Integer> h2 = new TreeSet<>(Arrays.asList(3, 4, 5, 6, 7));
        System.out.println(Main.getSimilar(h, h2).toString());

        //17
        h.add(213);

        //18
        Iterator<Integer> iterator = h.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //New section
        //19
        TreeSet<String> colors = new TreeSet<>();
        colors.add("blue");
        colors.add("yellow");
        colors.add("red");
        colors.add("green");
        System.out.println(colors.toString());

        //20
        Iterator<String> iterator1 = colors.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        //21
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 2));
        TreeSet<Integer> st = Main.reversedSet(ts);

        //22
        ts.remove(2);

        //23
        Integer lastElement = ts.pollLast();
        System.out.println("Last element removed: " + lastElement);

        //24
        System.out.println(ts.pollLast());

        //New section
        //25
        PriorityQueue<String> queue = new PriorityQueue<String>();
        queue.add("Red");
        queue.add("Green");
        queue.add("Orange");
        queue.add("White");
        queue.add("Black");
        System.out.println("Elements of the Priority Queue: ");
        System.out.println(queue);

        //26
        Iterator<String> iterator2 = queue.iterator();
        while (iterator2.hasNext()) {
            Object elem = iterator2.next();
            System.out.println(elem.toString());
        }

        //27
        PriorityQueue<String> pq1 = new PriorityQueue<String>();
        pq1.add("Red");
        pq1.add("Green");
        pq1.add("Black");
        pq1.add("White");

        pq1.clear();

        //28
        PriorityQueue<String> pq2 = new PriorityQueue<String>();
        pq1.add("Red");
        pq1.add("Green");
        pq1.add("Black");
        pq1.add("White");

        List<String> array_list = new ArrayList<String>(pq2);
        System.out.println(array_list);

        //29
        PriorityQueue<String> q2 = new PriorityQueue<String>();
        q2.add("Red");
        q2.add("Green");
        q2.add("Orange");
        System.out.println("Priority q2: " + q2);
        PriorityQueue<String> q = new PriorityQueue<String>();
        q.add("Pink");
        q.add("White");
        q.add("Black");
        System.out.println("Priority Queue2: " + q);

        q2.addAll(q);
        System.out.println("New Priority q2: " + q2);

        //30
        System.out.println(q2.size());

        //31
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(123, 321);
        hm.put(13, 321);
        hm.put(23, 321);
        hm.put(12, 321);
        System.out.println(hm.values().toString());

        //32
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        hm2.put(123, 321);
        hm2.put(13, 321);
        hm2.put(23, 321);
        hm2.put(12, 321);
        System.out.println(hm2.keySet().toString());

        //33
        System.out.println(hm.get(13));

        //34
        for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //35
        int tar = 321;
        if (hm.values().contains(tar)) {
            System.out.println('h');}

        //36
        System.out.println(hm.isEmpty());


        //New section


        //37
        TreeMap<String,String> tm=new TreeMap<String,String>();      
        
        // Put elements to the map 
        tm.put("C1", "Red");
        tm.put("C2", "Green");
        tm.put("C5", "Blue");
        TreeMap<String,String> tm2 = new TreeMap<String,String>();
        tm2.put("A1", "Orange");
        tm2.put("A2", "Pink");
        System.out.println(tm2);
        tm.putAll(tm2);
        System.out.println(tm);   
        

        //38
        if(tm.keySet().contains("C1")){
            System.out.println("found");
        }else{
            System.out.println("Not found");
        }
        
        //39
        if(tm.values().contains("Pink")){
            System.out.println("found");
        }else{
            System.out.println("Not found");
        }

        //40

        TreeMap <String,String> tre2 = new TreeMap <String,String> ();
        tre2.put("C1", "Red");
        tre2.put("C2", "Green");
        tre2.put("C3", "Black");
        tre2.put("C4", "White");

        System.out.println("greatest key" + tre2.firstEntry());
        System.out.println("least key" + tre2.lastEntry());

        //41

        TreeMap < Integer, String > tree_map = new TreeMap < Integer, String > ();

        tree_map.put(10, "Red");
        tree_map.put(20, "Green");
        tree_map.put(40, "Black");
        tree_map.put(50, "White");
        tree_map.put(60, "Pink");

        System.out.println("Value returned: " + tree_map.pollLastEntry());
        System.out.println("Value after poll: " + tree_map);
                
        //42
        tm.clear();
        
        




    }
}
