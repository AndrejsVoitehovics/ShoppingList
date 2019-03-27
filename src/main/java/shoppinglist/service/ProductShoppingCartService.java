package shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shoppinglist.database.ProductShopingCartDatabase;
import shoppinglist.domain.Product;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.domain.ShoppingCart;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductShoppingCartService {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final ProductShopingCartDatabase productShopingCartDatabase;

    @Autowired
    public ProductShoppingCartService(ShoppingCartService shoppingCartService, ProductService productService,
                                      ProductShopingCartDatabase productShopingCartDatabase) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.productShopingCartDatabase = productShopingCartDatabase;
    }

    @Transactional
    public Long addProductInShoppinCart(Long productId, Long shoppingCartId) {
        Product product = productService.findProductById(productId);
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId);
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setProduct(product);
        productShoppingCart.setShoppingCart(shoppingCart);
        return productShopingCartDatabase.saveProductShoppingCart(productShoppingCart);
    }

    @Transactional
    public List<ShoppingCart> findProductsByShoppingCartId(Long id) {
        return productShopingCartDatabase.getAllProductsInUserShoppingCart(id);
    }
}