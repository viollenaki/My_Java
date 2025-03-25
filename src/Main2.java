
interface Calculator {

    public int add(int a, int b);
}

class CalculatorImpl implements Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}

public class Main2 {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(3, 2));
        Calculator calculator2 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(calculator2.add(3, 2));
    }
}
