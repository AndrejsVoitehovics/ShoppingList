package shoppinglist.dto;

import shoppinglist.domain.Product;
import shoppinglist.domain.ShoppingCart;

public class ProductShoppingCartDTO {
    private Long productShoppingCartId;
    private Product product;
    private ShoppingCart shoppingCart;

    public ProductShoppingCartDTO() {
    }

    public ProductShoppingCartDTO(Long productShoppingCartId, Product product, ShoppingCart shoppingCart) {
        this.productShoppingCartId = productShoppingCartId;
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

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

}
