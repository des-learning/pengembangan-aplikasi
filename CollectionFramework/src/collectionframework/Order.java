package collectionframework;

import java.util.List;
import java.util.Objects;

public class Order {
    private final List<Product> products;
    private final Boolean isDelivered;

    public Order(List<Product> products, Boolean isDelivered) {
        this.products = products;
        this.isDelivered = isDelivered;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(products, order.products) &&
                Objects.equals(isDelivered, order.isDelivered);
    }

    @Override
    public int hashCode() {

        return Objects.hash(products, isDelivered);
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", isDelivered=" + isDelivered +
                '}';
    }
}
