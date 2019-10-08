package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.laptopy.polizingowe.dto.ProductDto;
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
}
