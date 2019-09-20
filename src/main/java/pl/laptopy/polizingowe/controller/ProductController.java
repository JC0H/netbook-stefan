package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.List;
import java.util.Objects;

@Controller
//@RequestMapping(name = "${api.stefan.notebook}")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
//
//    @GetMapping("/products")
//    public List<Product> getProducts(@RequestParam(value = "brand") String brand) {
//        return Objects.isNull(brand) ? productService.findAll() : productService.findAllByBrand(brand);
//    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

//    @RequestMapping(value = {"/","home"})
//    public String home() {
//        return "home";
//    }
//
//    @RequestMapping(value = {"hello"})
//    public String hello() {
//        return "hello";
//    }

    @RequestMapping(value = {"login"})
    public String login() {
        return "login";
    }

}


