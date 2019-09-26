package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.dto.ProductDTO;
import pl.laptopy.polizingowe.service.ProductService;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(@RequestParam(value = "brand", required = false) String brand) {
        return Objects.isNull(brand) ? productService.findAll() : productService.findAllByBrand(brand);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDTO saveProduct(@RequestBody ProductDTO dto) {
        return productService.saveProduct(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return productService.updateProduct(dto,id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
