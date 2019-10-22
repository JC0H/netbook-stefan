package pl.laptopy.polizingowe.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.mapper.ProductMapper;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ListConverter<Product> productListConverter;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private List<ProductDto> productDtoList;
    private FileStorageService fileStorageService;

    public ProductService(ListConverter<Product> productListConverter, ProductRepository productRepository, ProductMapper productMapper, FileStorageService fileStorageService) {
        this.productListConverter = productListConverter;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.fileStorageService = fileStorageService;
    }

    public ProductDto findOneProduct(Long productId) {
        return productMapper.mapToProductDto(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("no product with ID")));
    }

    public List<ProductDto> findAllByBrand(String brand) {
        List<ProductDto> dtoProducts = findAllProducts();

        return dtoProducts.stream()
                .filter(productDto -> productDto.getBrand().equals(brand))
                .collect(Collectors.toList()
                );
    }

    public List<ProductDto> findAllProducts() {
        if(Objects.isNull(productDtoList) || productDtoList.size() < countProducts()) {
            List<Product> products = productListConverter.convertIterableToList(productRepository.findAll());
            productDtoList = products.stream().map(
                    productMapper::mapToProductDto).collect(Collectors.toList()
            );
        }
        return productDtoList;
    }

    @Transactional
    public ProductDto saveProduct(ProductDto productDto,
                                  @RequestParam(required = true, value = "empJson") MultipartFile file)
            throws JsonParseException, JsonMappingException, IOException {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(fileName).toUriString();
        productDto.setProductPicPath(fileDownloadUri);
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
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

    @Transactional
    public void deleteProduct(Long productId) {
       productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(ProductDto productToUpdate) {
        productRepository.save(productMapper.mapToProduct(productToUpdate));
    }

    private Long countProducts() {
        Long dtoListSize = (long) productDtoList.size();
        return Optional.of(productRepository.count()).orElse(dtoListSize);
    }
}
