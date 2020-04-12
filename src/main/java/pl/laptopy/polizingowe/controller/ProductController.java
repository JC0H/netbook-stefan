package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        model.addAttribute("showSortButtons", true);
        return "html/products";
    }

    @GetMapping("/{productId}")
    public String getOneProduct(@PathVariable Long productId, Model model) {
        model.addAttribute("oneProduct", productService.findOneProduct(productId));
        return "html/oneProduct";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new ProductDto());
        return "html/productform";
    }

    @GetMapping("/{id}/update")
    public String updateProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.findOneProduct(Long.valueOf(id)));
        return "html/productform";
    }

    @PostMapping("product")
    public String saveOrUpdate(@ModelAttribute ProductDto productDto){
        ProductDto product = productService.saveProduct(productDto);
        return "redirect:/products/" + product.getId() + "/image";
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable String id){
        productService.deleteProduct(Long.valueOf(id));
        return "redirect:/products";
    }
}