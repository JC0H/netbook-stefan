package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDTO;
import pl.laptopy.polizingowe.service.PrdService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class PrdController {

    private final PrdService service;

    public PrdController(PrdService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", service.findAll());
        model.addAttribute("newProduct", new ProductDTO());
        return "products";
    }

    @PutMapping
    public String update(@RequestParam Long id, ProductDTO productDTO) {
        service.update(id, productDTO);
        return "redirect:/";
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("newProduct") ProductDTO productDTO) {
        service.create(productDTO);
        return "redirect:/";
    }
}
