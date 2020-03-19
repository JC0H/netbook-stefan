package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.laptopy.polizingowe.service.ProductService;

@Controller
public class MainPageController {

    private final ProductService productService;

    public MainPageController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"","/"})
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "html/products";
    }
}
