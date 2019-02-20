package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.util.ArrayList;


public class ProductNameValidation implements ProductValidationRule {
    private ArrayList<String> uniqueNames = new ArrayList<>();

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

        for (String elements : uniqueNames) {
            if (elements.equalsIgnoreCase(product.getName())) {
                throw new ProductValidationException("Product name Must be Unique");
            }
        }
        uniqueNames.add(product.getName());
    }

}
