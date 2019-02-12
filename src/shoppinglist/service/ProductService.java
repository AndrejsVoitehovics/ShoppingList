package shoppinglist.service;

import shoppinglist.database.Repository;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.Map;

public class ProductService {
    Repository repository = new Repository();
    ProductValidationService productValidationService = new ProductValidationService();

    public long createProduct(Product product) {
        productValidationService.validate(product);
        product.setActualPrice(calculateDiscount(product));
        Product createdProduct = repository.insert(product);
               return createdProduct.getId();
    }

    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = (product.getPrice().subtract(product.getPrice().divide(BigDecimal.valueOf(100)).multiply(product.getDiscount())));
        return discount;
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }


}
