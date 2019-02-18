package shoppinglist.service.validation;

import shoppinglist.domain.Product;

public class ProductDescriptionValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        final int MIN_DESCRIPTION_LENGTH = 3;
        final int MAX_DESCRIPTION_LENGTH = 50;
        checkNoNull(product);
        if (product.getDescription() == null) {
            throw new ProductValidationException("Product description cannon be null");
        }
        if (product.getDescription().length() < MIN_DESCRIPTION_LENGTH || product.getDescription().length() > MAX_DESCRIPTION_LENGTH) {
            throw new ProductValidationException("Product description cannon be <" + MIN_DESCRIPTION_LENGTH + "and > " + MAX_DESCRIPTION_LENGTH);
        }
    }
}
