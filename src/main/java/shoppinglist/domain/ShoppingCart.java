package shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @Column(name = "shoppingCartId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shoppingCartId;

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(shoppingCartId, that.shoppingCartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartId=" + shoppingCartId +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}