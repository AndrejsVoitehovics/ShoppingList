package shoppinglist.service;

import shoppinglist.database.ProductDatabase;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

public class ProductService {
    ProductDatabase productDatabase = new ProductDatabase();
    ProductValidationService productValidationService = new ProductValidationService();

    public long createProduct(Product product) {
        productValidationService.validate(product);
        product.setActualPrice(calculateDiscount(product));
        Product createdProduct = productDatabase.insert(product);
        return createdProduct.getId();
    }

    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount;
        discount = (product.getPrice().subtract(product.getPrice().divide(BigDecimal.valueOf(100)).multiply(product.getDiscount())));
        return discount;
    }

    public Product findProductById(Long id) {
        return productDatabase.findProductById(id);
    }
}
