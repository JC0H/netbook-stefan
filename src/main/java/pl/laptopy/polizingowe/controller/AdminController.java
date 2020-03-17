package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@Controller
@RequestMapping()
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts(@RequestParam(value = "brand", required = false) String brand,
                                 Model model) {
        List<ProductDto> products = brand == null ? productService.findAllProducts() : productService.findAllByBrand(brand);
        model.addAttribute("products", products);
        return "html/products";
    }

}
