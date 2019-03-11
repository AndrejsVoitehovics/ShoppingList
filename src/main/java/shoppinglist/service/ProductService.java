package shoppinglist.service;

import org.springframework.stereotype.Component;
import shoppinglist.database.Repository;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

@Component
public class ProductService {
    private final Repository repository;
    private final ProductValidationService productValidationService;

    public ProductService(Repository repository, ProductValidationService productValidationService) {
        this.repository = repository;
        this.productValidationService = productValidationService;
    }

    public long createProduct(Product product) {
        productValidationService.validate(product);
        product.setActualPrice(calculateDiscount(product));
        Product createdProduct = repository.insert(product);
        return createdProduct.getId();
    }

    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = (product.getPrice().subtract(product.getPrice().divide(BigDecimal.valueOf(100))
                .multiply(product.getDiscount())));
        return discount;
    }

    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }
}
