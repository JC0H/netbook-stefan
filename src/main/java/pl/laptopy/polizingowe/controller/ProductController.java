package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(value = "brand", required = false) String brand) {
        return Objects.isNull(brand) ? productService.findAllProducts() : productService.findAllByBrand(brand);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @DeleteMapping("${productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        ProductDto deletedProduct = productService.findProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(deletedProduct);
    }
}
