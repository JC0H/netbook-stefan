package pl.laptopy.polizingowe.rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.laptopy.polizingowe.config.AppConstants;
import pl.laptopy.polizingowe.config.AppResponse;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.service.FileStorageService;
import pl.laptopy.polizingowe.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(value = AppConstants.PRODUCTS_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createProduct(
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String prdJson,
            @RequestParam(required = true, value = AppConstants.FIRST_FILE) MultipartFile first_file,
            @RequestParam(required = true, value = AppConstants.SECOND_FILE) MultipartFile second_file)
            throws JsonParseException, JsonMappingException, IOException {
        String fileName = fileStorageService.storeFile(first_file);
        String firstFileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(fileName).toUriString();
        String secondFileName = fileStorageService.storeFile(second_file);
        String secondFileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(secondFileName).toUriString();

        Product product = objectMapper.readValue(prdJson, Product.class);
        product.setFirst_picture(firstFileDownloadUri);
        product.setSecond_picture(secondFileDownloadUri);
        productService.createProduct(product);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
    }

    @RequestMapping(value = AppConstants.PRODUCTS_URI, method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @RequestMapping(value = AppConstants.DOWNLOAD_URI, method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = AppConstants.DEFAULT_CONTENT_TYPE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
                .body(resource);
    }

}
