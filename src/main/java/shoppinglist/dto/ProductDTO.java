package shoppinglist.dto;

import shoppinglist.domain.Category;

import java.math.BigDecimal;

public class ProductDTO {
    private Long ProductId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productDiscount;
    private BigDecimal productActualPrice;
    private String productDescription;
    private Category.ProductCategory productCategory;

    public ProductDTO() {

    }

    public ProductDTO(Long productId, String productName, BigDecimal productPrice, BigDecimal productDiscount,
                      BigDecimal productActualPrice, String productDescription,
                      Category.ProductCategory productCategory) {
        ProductId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productActualPrice = productActualPrice;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
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

    public BigDecimal getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(BigDecimal productDiscount) {
        this.productDiscount = productDiscount;
    }

    public BigDecimal getProductActualPrice() {
        return productActualPrice;
    }

    public void setProductActualPrice(BigDecimal productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category.ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}