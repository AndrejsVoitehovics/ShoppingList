package shoppinglist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shoppinglist.domain.ProductShoppingCart;
import shoppinglist.dto.ProductShoppingCartDTO;
import shoppinglist.service.ProductShoppingCartService;

@RestController
@RequestMapping("/productshoppingcarts")
public class ProductShoppingCartController {

    private final ProductShoppingCartService productShoppingCartService;


    public ProductShoppingCartController(ProductShoppingCartService productShoppingCartService) {
        this.productShoppingCartService = productShoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ProductShoppingCart> create(@RequestBody ProductShoppingCartDTO productShoppingCartDTO) {
        ProductShoppingCart productShoppingCart = new ProductShoppingCart();
        productShoppingCart.setShoppingCart(productShoppingCartDTO.getShoppingCart());
        productShoppingCart.setProduct(productShoppingCartDTO.getProduct());
        productShoppingCartService.addProductInShoppinCart(productShoppingCartDTO.getProduct().getProductId(),
                productShoppingCartDTO.getShoppingCart().getShoppingCartId());
        return ResponseEntity.ok(productShoppingCart);
    }
}
