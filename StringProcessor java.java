import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringProcessor {

    public static void processStrings(List<String> list,
                                      Predicate<String> predicate,
                                      Function<String, String> function,
                                      Consumer<String> consumer) {

        for (String s : list) {
            if (predicate.test(s)) {
                String result = function.apply(s);
                consumer.accept(result);
            }
        }
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("programchalal");

        Predicate<String> p = s -> s.length() > 5;
        Function<String, String> f = s -> new StringBuilder(s).reverse().toString();
        Consumer<String> c = s -> System.out.println("ГАРШИЛ: " + s.toUpperCase());

        processStrings(words, p, f, c);
    }
}