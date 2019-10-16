package pl.laptopy.polizingowe.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.laptopy.polizingowe.dto.ProductDetailsDto;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.AppResponse;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.entity.ProductDetails;
import pl.laptopy.polizingowe.service.FileStorageService;
import pl.laptopy.polizingowe.service.ProductService;
import pl.laptopy.polizingowe.utils.AppConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "${api.stefan.notebook}" + "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ObjectMapper objectMapper ;
    private final FileStorageService fileStorageService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(value = "brand", required = false) String brand) {
        return Objects.isNull(brand) ? productService.findAllProducts() : productService.findAllByBrand(brand);
    }

//    @RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.GET)
//    public List<Employee> getAllEmployees() {
//        return applicationService.getAllEmployees();
//    }

    @RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createEmployee(
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
            @RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
            throws IOException {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(fileName).toUriString();

        ProductDto product = objectMapper.readValue(empJson, ProductDto.class);
        ProductDetailsDto productDetails = (ProductDetailsDto) product.getProductDetailsDtoList();
        productDetails.setProfilePicPath(fileDownloadUri);
        productService.saveProduct(product);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
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