package shoppinglist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import shoppinglist.domain.Product;
import shoppinglist.dto.ProductDTO;
import shoppinglist.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO, UriComponentsBuilder builder) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductDiscount(productDTO.getProductDiscount());
        product.setProductCategory(productDTO.getProductCategory());
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{ProductId}")
    public ProductDTO findProductById(@PathVariable("ProductId") Long id) {
        Product product = productService.findProductById(id);
        return new ProductDTO(product.getProductId(), product.getProductName(), product.getProductPrice(), product.getProductDiscount(),
                product.getProductActualPrice(), product.getProductDescription(), product.getProductCategory());
    }
}

