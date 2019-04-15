package shoppinglist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shoppinglist.domain.ShoppingCart;
import shoppinglist.dto.ShoppingCartDTO;
import shoppinglist.service.ShoppingCartService;

@RestController
@RequestMapping("/carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCartService.createShoppingCart(shoppingCart);
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping("/{shoppingCartId}")
    public ShoppingCartDTO findProductById(@PathVariable("shoppingCartId") Long id) {
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(id);
        return new ShoppingCartDTO(shoppingCart.getShoppingCartId());
    }
}
