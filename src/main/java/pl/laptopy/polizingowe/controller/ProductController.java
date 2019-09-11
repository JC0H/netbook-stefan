package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("stefan")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable(value = "brand") String brand) {
        return productService.findAllByBrand(brand);
    }

}


