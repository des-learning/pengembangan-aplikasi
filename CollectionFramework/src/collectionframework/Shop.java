package collectionframework;

import java.util.Collection;
import java.util.Objects;

public class Shop {
    private final String name;
    private final Collection<Customer> customers;

    public Shop(String name, Collection<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(name, shop.name) &&
                Objects.equals(customers, shop.customers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, customers);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
