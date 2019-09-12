package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;

@RestController
//@RequestMapping("stefan")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("stefan/products/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable(value = "brand") String brand) {
        return productService.findAllByBrand(brand);
    }

//    @GetMapping("/products/list")
//    @ModelAttribute("products")
//    public Iterable<Product> listProducts() {
//        return productService.findAll();
//    }

    @RequestMapping("/products/list")
    // removed: @RequestMapping({"/list", "/"})
    public String listProducts(Model model) {

        model.addAttribute("products", productService.findAll());

        return "products/list";
    }


}