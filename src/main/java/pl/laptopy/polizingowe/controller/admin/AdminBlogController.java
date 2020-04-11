package pl.laptopy.polizingowe.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.BlogDto;
import pl.laptopy.polizingowe.service.BlogService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminBlogController {

    private final BlogService blogService;

    @PostMapping("/new-blog")
    public String createNewBlog(Model model) {
        model.addAttribute("product", new BlogDto());
        return "html/newBlog";
    }

    @PostMapping("/edit/{blogId}")
    public String updateProduct(@PathVariable String blogId, Model model) {
        model.addAttribute("blog", blogService.findOne(Long.valueOf(blogId)));
        return "html/newBlog";
    }

    @DeleteMapping("/delete/{blogId}")
    public String deleteById(@PathVariable String blogId) {
        blogService.deleteBlogById(Long.valueOf(blogId));
        return "redirect:/blog";
    }

    @PostMapping("/save-or-update-blog")
    public String saveOrUpdate(@ModelAttribute BlogDto blogDto) {
        blogService.saveBlog(blogDto);
        return "redirect:/blog";
    }

}
