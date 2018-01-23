package collectionframework;

import java.util.List;
import java.util.Objects;

public class Customer {
    private final String name;
    private final City city;
    private final List<Order> orders;

    public Customer(String name, City city, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, city, orders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city=" + city +
                ", orders=" + orders +
                '}';
    }
}
