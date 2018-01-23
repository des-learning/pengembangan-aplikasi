package collectionframework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String []args) {
        Queue<Product> productsQueue = new LinkedList<>();

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
        ).forEach(productsQueue::offer);

        while (! productsQueue.isEmpty()) {
            // process queue
            System.out.println(productsQueue.poll());
        }
    }
}
