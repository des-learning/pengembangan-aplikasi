package collectionframework;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String []args) {
        Set<Product> products = new HashSet<>(Arrays.asList(
                new Product("IntelliJ IDEA Ultimate", 199.0),
                new Product("DotTrace", 159.0),
                new Product("DotTrace", 159.0),
                new Product("DotCover", 99.0),
                new Product("PhpStorm", 99.0),
                new Product("PyCharm", 99.0)
                ));

        Set<Product> otherProducts = new HashSet<>(Arrays.asList(
                new Product("IntelliJ IDEA Ultimate", 199.0),
                new Product("PyCharm", 99.0),
                new Product("AppCode", 99.0),
                new Product("RubyMine", 99.0),
                new Product("ReSharper", 149.0)
                ));

        displayProducts("Products", products);

        displayProducts("Other products", otherProducts);

        // union
        Set<Product> allProducts = new HashSet<>(products);
        allProducts.addAll(otherProducts);

        displayProducts("All products", allProducts);

        // common products (intersection)
        Set<Product> commonProducts = new HashSet<>(products);
        commonProducts.retainAll(otherProducts);

        displayProducts("Common products", commonProducts);

        // only available in on location (diferrence)
        Set<Product> uniqueProducts = new HashSet<>(products);
        uniqueProducts.removeAll(otherProducts);

        displayProducts("Only available here products", uniqueProducts);
    }

    private static void displayProducts(String label, Collection<Product> products) {
        System.out.println(label);
        products.forEach(System.out::println);
    }
}
