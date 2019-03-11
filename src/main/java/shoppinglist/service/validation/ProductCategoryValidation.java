package shoppinglist.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

@Component
public class ProductCategoryValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateProductForNullCategory(product);

    }

    private void validateProductForNullCategory(Product product) {
        if (product.getProductCategory() == null) {
            throw new ProductValidationException("Product category cannon be null");
        }
    }
}
