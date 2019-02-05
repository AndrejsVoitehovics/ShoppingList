package shoppinglist;

public interface ProductService {

    Long create(Product product);

    Product findBy(Long id);

}
