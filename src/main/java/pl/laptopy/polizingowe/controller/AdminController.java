package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", Collections.emptyList());
        return "/html/products";
    }

    @GetMapping("/admin/asd")
    public String adminPage2(Model model) {
        model.addAttribute("products", Collections.emptyList());
        return "/html/products";
    }

}
