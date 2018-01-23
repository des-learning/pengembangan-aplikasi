package collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestList {
    public static void main(String []args) {
        // products
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("IntelliJ IDEA Ultimate", 199.0),
                new Product("ReSharper", 149.0),
                new Product("DotTrace", 159.0),
                new Product("DotTrace", 159.0),
                new Product("DotCover", 99.0),
                new Product("AppCode", 99.0),
                new Product("PhpStorm", 99.0),
                new Product("PyCharm", 99.0),
                new Product("RubyMine", 99.0)
        ));

        // item size
        System.out.printf("Products number: %d\n", products.size());

        // add item
        products.add(new Product("WebStorm", 49.0));

        products.addAll(Arrays.asList(
                new Product("TeamCity", 99.0),
                new Product("YouTrack", 99.)));

        System.out.printf("Products number: %d\n", products.size());

        // manual iteration
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(product);
        }

        // iterator
        for (Product product: products) {
            System.out.println(product);
        }

        // java, using anonymous function
        products.forEach(new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                System.out.println(product);
            }
        });

        // java 8, lambda
        products.forEach(product ->
            System.out.println(product)
        );

        // java 8, using method/function reference
        products.forEach(System.out::println);

        // list contains
        Product p = new Product("DotTrace", 159.0);

        System.out.printf("%s in Products? %b\n", p.getName(), products.contains(p));
        System.out.printf("%s position %d\n", p.getName(), products.indexOf(p));
        System.out.printf("%s position %d\n", p.getName(), products.lastIndexOf(p));

        // remove 4th item
        products.remove(3);

        // sort product by price (lowest to highest/ascending)

        // using concrete class
        products.sort(new ProductPriceComparator());

        // anonymous class
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return new Double(product.getPrice() - t1.getPrice()).intValue();
            }
        });


        // java 8, using lambda (anonymous function)
        products.sort((p1, p2) -> new Double(p1.getPrice() - p2.getPrice()).intValue());
    }
}

// concrete class for implementing comparison method of product class by price
class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product, Product t1) {
        /*
         * -1 (negative) less than
         *  0  (zero) same as
         *  1  (positive) greater than
         */
        return new Double(product.getPrice() - t1.getPrice()).intValue();
    }
}
