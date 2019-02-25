package shoppinglist.service.validation;

import shoppinglist.database.Repository;
import shoppinglist.domain.Product;

import java.util.ArrayList;
import java.util.Optional;


public class ProductNameValidation implements ProductValidationRule {

    private final Repository repository;

    public ProductNameValidation(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateForNullName(product);
        validateForRangeName(product);
        validateForUniqueName(product);
    }

    private void validateForNullName(Product product) {
        if (product.getName() == null) {
            throw new ProductValidationException("Product name cannon be null");
        }
    }

    private void validateForRangeName(Product product) {
        final int MIN_NAME_LENGTH = 3;
        final int MAX_NAME_LENGTH = 32;
        if (product.getName().length() < MIN_NAME_LENGTH || product.getName().length() > MAX_NAME_LENGTH) {
            throw new ProductValidationException("Product name cannon be < " + MIN_NAME_LENGTH + "and > " + MAX_NAME_LENGTH);
        }
    }

    private void validateForUniqueName(Product product) {
        if (repository.findProductByName(product.getName()).isPresent()) {
            throw new ProductValidationException("Product name must be unique ");
        }
    }

}
