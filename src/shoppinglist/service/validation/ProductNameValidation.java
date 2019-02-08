package shoppinglist.service.validation;

import shoppinglist.domain.Product;

public class ProductNameValidation implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name cannon be null");
        }
        if (product.getName().length() < 3 || product.getName().length() > 35) {
            throw new ProductValidationException("Product name cannon be <3 and >35");
        }
    }
}
