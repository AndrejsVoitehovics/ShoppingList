package shoppinglist.service.validation;

import shoppinglist.database.Repository;
import shoppinglist.domain.Product;


public class ProductNameValidation implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        Repository repository = new Repository();
        checkNoNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("Product name cannon be null");
        }
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Product name cannon be <3 and >32");
        }
        if (repository.findUniqueProductName(product.getName())) {
            throw new ProductValidationException("Product name must be unique");
        }

    }
}
