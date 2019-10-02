package pl.laptopy.polizingowe.service;

import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.errors.ApiException;
import pl.laptopy.polizingowe.errors.ErrorCode;
import pl.laptopy.polizingowe.mapper.ProductMapper;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ListConverter<Product> productListConverter;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ListConverter<Product> productListConverter, ProductRepository productRepository, ProductMapper productMapper) {
        this.productListConverter = productListConverter;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> findAllByBrand(String brand) {
        List<ProductDto> dtoProducts = findAllProducts();

        return dtoProducts.stream()
                .filter(productDto -> productDto.getBrand().equals(brand))
                .collect(Collectors.toList()
                );
    }

    public List<ProductDto> findAllProducts() {
        List<Product> products = productListConverter.convertIterableToList(productRepository.findAll());
        return products.stream().map(
                productMapper::mapToProductDto).collect(Collectors.toList()
        );
    }

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void updateProduct(ProductDto productDto) {
        Product productToUpdate = productMapper.mapToProduct(productDto);
        productRepository.save(productToUpdate);
    }

    public ProductDto findProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ApiException(ErrorCode.NO_PRODUCT_WITH_GIVEN_ID)
        );
        return productMapper.mapToProductDto(product);
    }
}
