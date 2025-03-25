import java.time.LocalDateTime;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface {
    public static void main(String[] args) {
    Function<Integer,Double> f = n->n/1.0;
    System.out.println(f.apply(10));
    System.out.println(f.apply(20));

    Predicate<Integer> p = n->{
        if(n%2==0){
            return true;
        }else{
            return false;
        }
    };
    
    System.out.println(p.test(10));
    System.out.println(p.test(11));


    Supplier<LocalDateTime> s = ()->LocalDateTime.now();
    System.out.println(s.get());


    UnaryOperator<Integer> doulbeOper = n-> 2*n;

    System.out.println(doulbeOper.apply(10));


    BinaryOperator<Boolean> andOper = (b1, b2) -> b1 && b2;
    System.out.println(andOper.apply(true, true));



    }
}
