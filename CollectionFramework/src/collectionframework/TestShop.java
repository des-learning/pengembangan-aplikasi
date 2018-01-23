package collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestShop {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, City> cities = new HashMap<>();
    private Map<String, Shop> shops = new HashMap<>();

    public TestShop() {
        // products
        Arrays.asList(
                new Product("IntelliJ IDEA Ultimate", 199.0),
                new Product("ReSharper", 149.0),
                new Product("DotTrace", 159.0),
                new Product("DotMemory", 129.0),
                new Product("DotCover", 99.0),
                new Product("AppCode", 99.0),
                new Product("PhpStorm", 99.0),
                new Product("PyCharm", 99.0),
                new Product("RubyMine", 99.0),
                new Product("WebStorm", 49.0),
                new Product("TeamCity", 299.0),
                new Product("YouTrack", 500.0)
        ).forEach(product -> products.put(product.getName().split(" ")[0].toLowerCase(), product));

        // cities
        Arrays.asList(
                new City("Canberra"),
                new City("Vancouver"),
                new City("Budapest"),
                new City("Ankara"),
                new City("Tokyo")
        ).forEach(city -> cities.put(city.getName().toLowerCase(), city));

        customers.put("lucas", new Customer("Lucas", cities.get("canberra"),
                Arrays.asList(
                        new Order(Collections.singletonList(products.get("resharper")), true),
                        new Order(Arrays.asList(
                                products.get("resharper"),
                                products.get("dotmemory"),
                                products.get("dottrace")
                        ), true)
                )));

        customers.put("cooper", new Customer("Cooper", cities.get("canberra"), new ArrayList<>()));
        customers.put("nathan", new Customer("Nathan", cities.get("vancouver"),
                Collections.singletonList(
                        new Order(Arrays.asList(
                                products.get("rubymine"),
                                products.get("webstorm")
                        ), true)
                )));
        customers.put("reka", new Customer("Reka", cities.get("budapest"),
                Arrays.asList(
                        new Order(Collections.singletonList(
                                products.get("intellij")
                        ), false),
                        new Order(Collections.singletonList(
                                products.get("intellij")
                        ), false),
                        new Order(Collections.singletonList(
                                products.get("intellij")
                        ), true)
                )));
        customers.put("bajram", new Customer("Bajram", cities.get("ankara"),
                Collections.singletonList(
                        new Order(Collections.singletonList(products.get("reshaper")), true)
                )));
        customers.put("asuka", new Customer("Asuka", cities.get("tokyo"),
                Collections.singletonList(
                        new Order(Collections.singletonList(products.get("intellij")), true)
                )));

        shops.put("jetbrains", new Shop("JetBrains", customers.values()));
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public Map<String, City> getCities() {
        return cities;
    }

    public Map<String, Shop> getShops() {
        return shops;
    }
}
