package shoppinglist.service.validation;

import shoppinglist.domain.Product;

public class ProductDescriptionValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        if (product.getDescription().length() < 3 || product.getDescription().length() > 50) {
            throw new ProductValidationException("Product description cannon be <3 and >50");
        }
        if (product.getDescription() == null) {
            throw new ProductValidationException("Product description cannon be null");
        }
    }


}
