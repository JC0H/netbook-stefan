package pl.laptopy.polizingowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.ImageService;
import pl.laptopy.polizingowe.service.ProductService;
import pl.laptopy.polizingowe.utils.ImageUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jt on 7/3/17.
 */
@Controller
public class ImageController {

    private final ImageService imageService;
    private final ProductService productService;

    public ImageController(ImageService imageService, ProductService productService) {
        this.imageService = imageService;
        this.productService = productService;
    }


    @GetMapping("products/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("product", productService.findOneProduct(Long.valueOf(id)));
        return "html/imageuploadform";
    }

    @PostMapping("products/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
        imageService.saveImageFile(Long.valueOf(id), file);
        return "redirect:/products";
    }

    @GetMapping("products/{id}/productimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        ProductDto productDto = productService.findOneProduct(Long.valueOf(id));
        ImageUtils.render(response, productDto);
    }


}
