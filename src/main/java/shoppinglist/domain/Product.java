package shoppinglist.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long ProductId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productDiscount;
    private BigDecimal productActualPrice;
    private String productDescription;

    public BigDecimal getProductActualPrice() {
        return productActualPrice;
    }

    public Category.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductActualPrice(BigDecimal productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public BigDecimal getProductDiscount() {
        return productDiscount;
    }

    private Category.ProductCategory productCategory;

    public void setProductCategory(Category.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        this.ProductId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ProductId, product.ProductId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice) &&
                Objects.equals(productDiscount, product.productDiscount) &&
                Objects.equals(productActualPrice, product.productActualPrice) &&
                Objects.equals(productDescription, product.productDescription) &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId, productName, productPrice, productDiscount, productActualPrice, productDescription, productCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDiscount=" + productDiscount +
                ", productActualPrice=" + productActualPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory=" + productCategory +
                '}';
    }
}