package shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_shopping_cart")
public class ProductShoppingCart {
    @Id
    @Column(name = "productShoppingCartId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productShoppingCartId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shoppingCartId")
    private ShoppingCart shoppingCart;

    public Long getProductShoppingCartId() {
        return productShoppingCartId;
    }

    public void setProductShoppingCartId(Long productShoppingCartId) {
        this.productShoppingCartId = productShoppingCartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductShoppingCart that = (ProductShoppingCart) o;
        return Objects.equals(productShoppingCartId, that.productShoppingCartId) &&
                Objects.equals(product, that.product) &&
                Objects.equals(shoppingCart, that.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productShoppingCartId, product, shoppingCart);
    }

    @Override
    public String toString() {
        return "ProductShoppingCart{" +
                "productShoppingCartId=" + productShoppingCartId +
                ", product=" + product +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
