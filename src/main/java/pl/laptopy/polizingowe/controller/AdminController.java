package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
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

    @GetMapping("/{productId}")
    public String getOneProduct(@PathVariable Long productId, Model model) {
        model.addAttribute("oneProduct", productService.findOneProduct(productId));
        return "html/oneProduct";
    }


    @GetMapping("/edit/{productId}")
    public String updateRecipe(@PathVariable String productId, Model model){
        model.addAttribute("products", productService.findOneProduct(Long.valueOf(productId)));
        return  "html/updateProduct";
    }


}
