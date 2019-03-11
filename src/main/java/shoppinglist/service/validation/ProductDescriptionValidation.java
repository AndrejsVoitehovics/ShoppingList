package shoppinglist.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

@Component
public class ProductDescriptionValidation implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        checkNoNull(product);
        validateForNullDescription(product);
        validateForLengthDescription(product);
    }

    private void validateForNullDescription(Product product) {
        if (product.getDescription() == null) {
            throw new ProductValidationException("Product description cannon be null");
        }
    }

    private void validateForLengthDescription(Product product) {
        final int MAX_DESCRIPTION_LENGTH = 50;
        final int MIN_DESCRIPTION_LENGTH = 3;
        if (product.getDescription().length() < MIN_DESCRIPTION_LENGTH || product.getDescription().length() > MAX_DESCRIPTION_LENGTH) {
            throw new ProductValidationException("Product description cannon be <" + MIN_DESCRIPTION_LENGTH + " and > " + MAX_DESCRIPTION_LENGTH);
        }
    }
}
