package shoppinglist.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import shoppinglist.database.DefaultDatabase;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;

@Component
@Profile({"local", "dev"})
public class DefaultProductService implements ProductService {
    private final DefaultDatabase defaultDatabase;
    private final ProductValidationService productValidationService;

    public DefaultProductService(DefaultDatabase defaultDatabase, ProductValidationService productValidationService) {
        this.defaultDatabase = defaultDatabase;
        this.productValidationService = productValidationService;
    }

    @Override
    public Long createProduct(Product product) {
        productValidationService.validate(product);
        product.setActualPrice(calculateDiscount(product));
        Long createdProduct = defaultDatabase.insert(product);
        return createdProduct;
    }

    @Override
    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = (product.getPrice().subtract(product.getPrice().divide(BigDecimal.valueOf(100))
                .multiply(product.getDiscount())));
        return discount;
    }

    @Override
    public Product findProductById(Long id) {
        return defaultDatabase.findProductById(id);
    }
}
