package shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import shoppinglist.database.Database;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.Optional;


@Component
@Profile("inMemory")
public class InMemoryProductService implements ProductService {
    private final Database database;
    private final ProductValidationService productValidationService;
    @Autowired
    public InMemoryProductService(Database database, ProductValidationService productValidationService) {
        this.database = database;
        this.productValidationService = productValidationService;
    }

    public Long createProduct(Product product) {
        productValidationService.validate(product);
        product.setProductActualPrice(calculateDiscount(product));
        Long createdProduct = database.insert(product);
        return createdProduct;
    }

    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = (product.getProductPrice().subtract(product.getProductPrice().divide(BigDecimal.valueOf(100))
                .multiply(product.getProductDiscount())));
        return discount;
    }

    public Optional<Product> findProductById(Long id) {
        return database.findProductById(id);
    }
}
