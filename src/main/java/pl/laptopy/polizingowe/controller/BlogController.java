package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.laptopy.polizingowe.service.BlogService;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public String getAllBlogs(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "html/blog";
    }

    @GetMapping("/{blogId}")
    public String getBlogById(@PathVariable("blogId") Long blogId , Model model) {
        blogService.findOne(blogId);
        return "redirect:/blog";
    }
}
