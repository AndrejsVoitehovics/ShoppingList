package shoppinglist.service.validation;

import java.util.HashSet;
import java.util.Set;

import shoppinglist.database.Repository;
import shoppinglist.domain.Product;

public class ProductValidationService {
    private final Repository repository;
    private Set<ProductValidationRule> validationRules = new HashSet();

    public ProductValidationService(Repository repository) {
        this.repository = repository;
        validationRules.add(new ProductNameValidation(repository));
        validationRules.add(new ProductDescriptionValidation());
        validationRules.add(new ProductCategoryValidation());
        validationRules.add(new ProductPriceValidation());
        validationRules.add(new ProductDiscountValidation());
    }

    public void validate(Product product) {
        validationRules.forEach(i -> i.validate(product));
    }
}
