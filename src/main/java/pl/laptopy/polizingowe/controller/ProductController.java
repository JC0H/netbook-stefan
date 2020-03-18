package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"","/"})
    public String getIndexPage(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "html/products";
    }

    @GetMapping("products/{productId}")
    public String getOneProduct(@PathVariable Long productId, Model model) {
        model.addAttribute("oneProduct", productService.findById(productId));
        return "html/oneProduct";
    }

    @GetMapping("/products/new")
    public String newProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "html/productform";
    }

    @GetMapping("/products/{id}/update")
    public String updateProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.findCommandById(Long.valueOf(id)));
        return "html/productform";
    }

    @PostMapping("product")
    public String saveOrUpdate(@ModelAttribute ProductDto productDto){
        productService.saveProductCommand(productDto);
        return "redirect:/";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteById(@PathVariable String id){
        productService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
