package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/products")
public class MainController {

    @GetMapping
    public String welcome() {
        return "products";
    }

}
