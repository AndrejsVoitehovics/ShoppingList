package shoppinglist.service.validation;

import shoppinglist.domain.Product;

public class ProductCategoryValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        if (product.getProductCategory() == null) {
            throw new ProductValidationException("Product category cannon be null");
        }
    }
}
