package shoppinglist.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shoppinglist.domain.Product;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.domain.ShoppingCart;

import java.util.Optional;

@Service
public class ProductShoppingCartService {
    ProductShoppingCart productShoppingCart;
    ShoppingCartService shoppingCartService;
    ProductService productService;
    ProductShoppingCartService productShoppingCartService;

    public ProductShoppingCartService(ShoppingCartService shoppingCartService, ProductService productService, ProductShoppingCartService productShoppingCartService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.productShoppingCartService = productShoppingCartService;
    }

    public Long addProductInShoppinCart(Long productId, Long shoppingCartId) {
        Optional<Product> product = productService.findProductById(productId);
        Optional<ShoppingCart> shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId);
        return productShoppingCart.getProductShoppingCartId();
    }
}