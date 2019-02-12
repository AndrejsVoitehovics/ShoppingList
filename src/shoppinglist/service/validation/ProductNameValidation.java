package shoppinglist.service.validation;

import shoppinglist.domain.Product;

import java.util.ArrayList;


public class ProductNameValidation implements ProductValidationRule {
    private ArrayList<String> uniqueNames = new ArrayList<>();

    @Override
    public void validate(Product product) {
        checkNoNull(product);
        for (String elements : uniqueNames) {
            if (elements.equalsIgnoreCase(product.getName())) {
                throw new ProductValidationException("Product name Must be Unique");
            }
        }
        uniqueNames.add(product.getName());
        if (product.getName() == null) {
            throw new ProductValidationException("Product name cannon be null");
        }
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ProductValidationException("Product name cannon be <3 and >32");
        }
    }
}
