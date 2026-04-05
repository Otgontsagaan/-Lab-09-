import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {

        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .sorted((a, b) -> b.getPrice() - a.getPrice())
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {

        List<Product> list = Arrays.asList(
                new Product("Gutal", 1500, "Huwtsas"),
                new Product("Tsamts", 1200, "Huwtsas"),
                new Product("Malgai", 800, "Huwtsas")
        );

        Map<String, List<Product>> result = analyze(list);

        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}