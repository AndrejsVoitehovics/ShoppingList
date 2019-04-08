package shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import shoppinglist.database.Database;
import shoppinglist.domain.Product;
import shoppinglist.service.validation.ProductValidationService;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Profile({"local", "hibernate"})
public class DefaultProductService implements ProductService {
    private final Database database;
    private final ProductValidationService productValidationService;

    @Autowired
    public DefaultProductService(Database database, ProductValidationService productValidationService) {
        this.database = database;
        this.productValidationService = productValidationService;
    }

    @Transactional
    @Override
    public Long createProduct(Product product) {
        productValidationService.validate(product);
        product.setProductActualPrice(calculateDiscount(product));
        Long createdProduct = database.insert(product);
        return createdProduct;
    }

    @Override
    public BigDecimal calculateDiscount(Product product) {
        BigDecimal discount = (product.getProductPrice().subtract(product.getProductPrice().divide(BigDecimal.valueOf(100))
                .multiply(product.getProductDiscount())));
        return discount;
    }

    @Transactional
    @Override
    public Product findProductById(Long id) {
        return database.findProductById(id);
    }
}