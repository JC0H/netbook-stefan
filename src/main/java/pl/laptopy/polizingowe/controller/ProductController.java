package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "${app.stefan.netbook}" + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/brand")
    public List<Product> getProducts(@RequestParam(value = "brand") String brand) {
        return Objects.isNull(brand) ? productService.findAll() : productService.findAllByBrand(brand);
    }

}


