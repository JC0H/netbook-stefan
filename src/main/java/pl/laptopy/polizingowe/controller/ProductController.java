package pl.laptopy.polizingowe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@Slf4j
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAllProducts(@RequestParam(value = "brand", required = false) String brand,
                                 Model model) {
        List<ProductDto> products = brand == null ? productService.findAllProducts() : productService.findAllByBrand(brand);
        model.addAttribute("products", products);
        return "html/products";
    }

    @GetMapping("products/{productId}")
    public String getOneProduct(@PathVariable Long productId, Model model) {
        model.addAttribute("oneProduct", productService.findOneProduct(productId));
        return "html/oneProduct";
    }

    @GetMapping("/products/{productId}/show")
    public String updateRecipe(@PathVariable String productId, Model model){
        model.addAttribute("product", productService.findOneProduct(Long.valueOf(productId)));
        return "html/show";
    }

    @GetMapping("/products/new")
    public String newProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "html/productform";
    }

    @PostMapping("product")
    public String saveOrUpdate(@ModelAttribute ProductDto command){
        ProductDto savedCommand = productService.saveProduct(command);
        return "redirect:/products/" + savedCommand.getId() + "/show";
    }
}
