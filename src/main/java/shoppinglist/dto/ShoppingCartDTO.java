package shoppinglist.dto;

public class ShoppingCartDTO {
    private Long shoppingCartId;

    public ShoppingCartDTO() {
    }

    public ShoppingCartDTO(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }


    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
