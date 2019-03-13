package shoppinglist.service.validation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import shoppinglist.database.InMemoryDatabase;
import shoppinglist.domain.Product;

@Component
public class ProductValidationService {
    private final InMemoryDatabase inMemoryDatabase;
    private Set<ProductValidationRule> validationRules = new HashSet();

    public ProductValidationService(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
        validationRules.add(new ProductNameValidation(inMemoryDatabase));
        validationRules.add(new ProductDescriptionValidation());
        validationRules.add(new ProductCategoryValidation());
        validationRules.add(new ProductPriceValidation());
        validationRules.add(new ProductDiscountValidation());
    }

    public void validate(Product product) {
        validationRules.forEach(i -> i.validate(product));
    }
}
