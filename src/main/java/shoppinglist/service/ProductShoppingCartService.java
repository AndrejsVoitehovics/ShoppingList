package shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shoppinglist.database.ProductShopingCartDatabase;
import shoppinglist.domain.Product;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.domain.ShoppingCart;

import java.util.Optional;

@Service
public class ProductShoppingCartService {
    ProductShoppingCart productShoppingCart;
    ShoppingCartService shoppingCartService;
    ProductService productService;
    ProductShopingCartDatabase productShopingCartDatabase;
    @Autowired
    public ProductShoppingCartService(ProductShoppingCart productShoppingCart, ShoppingCartService shoppingCartService,
                                      ProductService productService, ProductShopingCartDatabase productShopingCartDatabase) {
        this.productShoppingCart = productShoppingCart;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.productShopingCartDatabase = productShopingCartDatabase;
    }

    public Long addProductInShoppinCart(Long productId, Long shoppingCartId) {
        Product product = productService.findProductById(productId);
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId);
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setProduct(product);
        productShoppingCart.setShoppingCart(shoppingCart);
        return productShopingCartDatabase.saveProductShoppingCart(productShoppingCart);
    }
}