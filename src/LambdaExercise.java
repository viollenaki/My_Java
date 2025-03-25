
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface MathOperation {

    int operation(int a, int b);
}

interface OddNumbers {

    String oddNumbers();
}

interface Sorting {

    String sorting();
}

interface StringManipul {

    String manipulate(String s);
}

public class LambdaExercise {

    public static void main(String[] args) {
        MathOperation add = (int a, int b) -> a + b;
        MathOperation subtract = (int a, int b) -> a - b;
        MathOperation multiply = (int a, int b) -> a * b;
        MathOperation divide = (int a, int b) -> a / b;
        System.out.println(add.operation(5, 3));
        System.out.println(subtract.operation(5, 3));
        System.out.println(multiply.operation(5, 3));
        System.out.println(divide.operation(5, 3));

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Predicate<Integer> isOdd = (Integer i) -> i % 2 != 0;
        OddNumbers oddNumbers = () -> {
            String result = "";
            for (int i : numbers) {
                if (isOdd.test(i)) {
                    result += i + " ";
                }
            }
            return result;
        };

        System.out.println(oddNumbers.oddNumbers());

        List<String> names = Arrays.asList("Gul", "Nasipa", "Sako", "Ala");

        Sorting sorting = () -> {
            names.sort((a, b) -> b.compareTo(a));
            return names.toString();
        };

        System.out.println(sorting.sorting());
        StringManipul sm = (String s) -> {
            String newS = "";
            for (int i = s.length() - 1; i > -1; i--) {
                newS += Character.toUpperCase(s.charAt(i));
            }
            return newS;
        };
        Function<String, String> sm2 = (String s) -> {
            String newS = "";
            for (int i = s.length() - 1; i > -1; i--) {
                newS += Character.toUpperCase(s.charAt(i));
            }
            return newS;
        };
        System.out.println(sm2.apply("hello"));
        System.out.println(sm.manipulate("hello"));

        List<String> cities = Arrays.asList("Astana", "Almaty", "Shymkent", "Kokshetau", "Karaganda");
        Consumer<List<String>> printCities = (List<String> c) -> {
            for (String city : c) {
                System.out.println(city);
            }
        };
        printCities.accept(cities);
        List<String> newCities = Arrays.asList("New York", "London", "Tokyo", "Berlin");

        // Using method reference to print each city
        newCities.forEach(System.out::println);
        BiFunction<Integer, Integer, Integer> compare = (a, b) -> {
            if (a > b) {
                System.out.println("max"+ a.toString());
                System.out.println("min"+ b.toString());

            } else {
                System.out.println("max"+ b.toString());
                System.out.println("min"+ a.toString());
            }
            return a > b ? a : b;
        };
        compare.apply(5, 3);
        






    }
}
