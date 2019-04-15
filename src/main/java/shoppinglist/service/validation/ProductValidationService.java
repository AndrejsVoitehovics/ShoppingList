package shoppinglist.service.validation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import shoppinglist.database.Database;
import shoppinglist.domain.Product;

@Component
public class ProductValidationService {
    private final Database database;
    private Set<ProductValidationRule> validationRules = new HashSet();


    public ProductValidationService(Database database) {
        this.database = database;
        validationRules.add(new ProductNameValidation(database));
        validationRules.add(new ProductDescriptionValidation());
        validationRules.add(new ProductCategoryValidation());
        validationRules.add(new ProductPriceValidation());
        validationRules.add(new ProductDiscountValidation());
    }

    public void validate(Product product) {
        validationRules.forEach(i -> i.validate(product));
    }
}
