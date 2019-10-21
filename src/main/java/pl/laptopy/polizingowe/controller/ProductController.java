package pl.laptopy.polizingowe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(value = "brand", required = false) String brand) {
        List<ProductDto> fetchedProducts = productService.findAllProducts();
        log.info("Fetched {} products.", fetchedProducts.size());
        return fetchedProducts;
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) {
        log.info("Product crated: {}", productDto);
        System.out.println(productDto.toString());
        productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        log.info("Deleted: " + productId);
        return ResponseEntity.accepted()
                .body("Resource was marked for deletion with id: " + productId);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductDto productToUpdate) {
        productService.updateProduct(productToUpdate);
        return ResponseEntity.accepted().body(productToUpdate);
    }
}
