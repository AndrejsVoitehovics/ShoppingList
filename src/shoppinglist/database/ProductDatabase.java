package shoppinglist.database;

import shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    private Long PRODUCT_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        products.put(PRODUCT_ID_SEQUENCE, product);
        PRODUCT_ID_SEQUENCE++;
        System.out.println("Product with id " + product.getId() + " added in database");
        return product;
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }
}
