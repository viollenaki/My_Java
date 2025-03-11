
import java.util.ArrayList;
import java.util.List;

class Storage<T> {

    private List<T> elements;

    public Storage() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T get(int idx) {
        if (idx >= 0 && idx < elements.size()) {
            return elements.get(idx);
        }
        return null;
    }

    public boolean remove(int idx) {
        if (idx >= 0 && idx < elements.size()) {
            elements.remove(idx);
            return true;
        }
        return false;
    }

    public boolean remove(T element) {
        return elements.remove(element);
    }

    public int size() {
        return elements.size();
    }

    public void displayAll() {
        System.out.println("Элементы хранилища");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(i + " ->" + elements.get(i));
        }
    }
}

class Util_class {

    public static <E> void printList(List<E> list) {
        System.out.println("Элементы списка:");
        for (E element : list) {
            System.out.println(element);
        }
    }
}

public class generics {

    public static void main(String[] args) {
        Storage<Integer> for_int = new Storage<>();

        for_int.add(10);
        for_int.add(20);
        for_int.add(30);
        for_int.add(40);

        System.out.println("Размер " + for_int.size());
        for_int.displayAll();

        System.out.println(for_int.get(1));
        for_int.remove(1);
        for_int.displayAll();

        Storage<String> for_string = new Storage<>();

        for_string.add("Привет");
        for_string.add("Мир");
        for_string.add("Java");
        for_string.add("Generics");

        System.out.println("Размер " + for_string.size());
        for_string.displayAll();

        System.out.println("Элемент 2: " + for_string.get(2));
        for_string.remove("Мир");
        for_string.displayAll();

        Storage<Double> for_double = new Storage<>();

        for_double.add(3.14);
        for_double.add(2.71);
        for_double.add(1.618);

        System.out.println("Размер " + for_double.size());
        for_double.displayAll();

        List<String> stringList = new ArrayList<>();

        stringList.add("Один");
        stringList.add("Два");
        stringList.add("Три");

        Util_class.printList(stringList);
    }
}
