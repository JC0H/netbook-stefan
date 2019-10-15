package pl.laptopy.polizingowe.service;

import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.mapper.ProductMapper;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.io.ObjectInputStream;
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
        if(Objects.isNull(productDtoList) || productDtoList.size() < countProducts()) {
            List<Product> products = productListConverter.convertIterableToList(productRepository.findAll());
            productDtoList = products.stream().map(
                    productMapper::mapToProductDto).collect(Collectors.toList()
            );
        }
        return productDtoList;
    }

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        productDtoList = null;
        return productMapper.mapToProductDto(savedProduct);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void updateProduct(ProductDto productToUpdate) {
//        productRepository.save(productMapper.mapToProduct(productToUpdate));
        System.out.println("ProductUpdated " + productToUpdate.toString());
    }

    private Long countProducts() {
        Long dtoListSize = (long) productDtoList.size();
        return Optional.of(productRepository.count()).orElse(dtoListSize);
    }
}
