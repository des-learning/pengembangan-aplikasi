package collectionframework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String []args) {
        Map<String, Product> products = new HashMap<>();

        products.put("webstorm", new Product("WebStorm", 49.0));
        products.put("teamcity", new Product("TeamCity", 299.0));
        products.put("youtrack", new Product("YouTrack", 500.0));

        Arrays.asList(
                new Product("IntelliJ IDEA Ultimate", 199.0),
                new Product("ReSharper", 149.0),
                new Product("DotTrace", 159.0),
                new Product("DotTrace", 159.0),
                new Product("DotCover", 99.0),
                new Product("AppCode", 99.0),
                new Product("PhpStorm", 99.0),
                new Product("PyCharm", 99.0),
                new Product("RubyMine", 99.0)
        ).forEach(product -> {
            products.put(product.getName(), product);
        });

        products.forEach((name, product) -> {
            System.out.println(name);
            System.out.println(product);
            System.out.println("======");
        });

        // all keys
        products.keySet().forEach(System.out::println);

        // all values
        products.values().forEach(System.out::println);
    }
}
