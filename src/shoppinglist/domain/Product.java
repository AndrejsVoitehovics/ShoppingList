package shoppinglist.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal actualPrice;
    private String description;

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public Category.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    private Category.ProductCategory productCategory;

    public void setProductCategory(Category.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(actualPrice, product.actualPrice) &&
                Objects.equals(description, product.description) &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, discount, actualPrice, description, productCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", actualPrice=" + actualPrice +
                ", description='" + description + '\'' +
                ", productCategory=" + productCategory +
                '}';
    }
}