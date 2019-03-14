package shoppinglist.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.database.Database;
import shoppinglist.domain.Product;

@Component
public class ProductNameValidation implements ProductValidationRule {

    private final Database database;

    public ProductNameValidation(Database database) {
        this.database = database;
    }

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateForNullName(product);
        validateForRangeName(product);
        validateForUniqueName(product);
    }

    private void validateForNullName(Product product) {
        if (product.getProductName() == null) {
            throw new ProductValidationException("Product name cannon be null");
        }
    }

    private void validateForRangeName(Product product) {
        final int MIN_NAME_LENGTH = 3;
        final int MAX_NAME_LENGTH = 32;
        if (product.getProductName().length() < MIN_NAME_LENGTH || product.getProductName().length() > MAX_NAME_LENGTH) {
            throw new ProductValidationException("Product name cannon be < " + MIN_NAME_LENGTH + "and > " + MAX_NAME_LENGTH);
        }
    }

    private void validateForUniqueName(Product product) {
        if (database.findProductByName(product.getProductName()).isPresent()) {
            throw new ProductValidationException("Product name must be unique ");
        }
    }

}
