package pl.laptopy.polizingowe.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.laptopy.polizingowe.config.AppConstants;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.service.FileStorageService;
import pl.laptopy.polizingowe.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    private final FileStorageService fileStorageService;

    public ProductController(ProductService productService, FileStorageService fileStorageService) {
        this.productService = productService;
        this.fileStorageService = fileStorageService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> fetchedProducts = productService.findAllProducts();
        log.info("Fetched {} products.", fetchedProducts.size());
        return fetchedProducts;
    }

    @GetMapping("/{productId}")
    public ProductDto getOneProduct(@PathVariable Long productId) {
        return productService.findOneProduct(productId);
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) {
        log.info("Product crated: {}", productDto);
        System.out.println(productDto.toString());
        productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @RequestMapping(value = "/downloadFile/{fileName:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format("attachment; filename=\"%s\"", resource.getFilename()))
                .body(resource);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        log.info("Deleted: " + productId);
        return ResponseEntity.accepted()
                .body("Resource was marked for deletion with id: " + productId);
    }

    @PatchMapping
    public ResponseEntity updateProduct(@RequestBody ProductDto productToUpdate) {
        productService.updateProduct(productToUpdate);
        return ResponseEntity.accepted().body(productToUpdate);
    }
}
