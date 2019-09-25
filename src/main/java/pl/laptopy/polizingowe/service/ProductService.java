package pl.laptopy.polizingowe.service;

import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.dto.ProductDTO;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ListConverter<Product> productListConverter;
    private final ProductRepository productRepository;

    public ProductService(ListConverter<Product> productListConverter, ProductRepository productRepository) {
        this.productListConverter = productListConverter;
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAllByBrand(String brand) {
        return productRepository.findAllByBrand(brand).stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getBrand(), entity.getProductDetailsList()))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> findAll() {
        return productListConverter.convertIterableToList(productRepository.findAll()).stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getBrand(), entity.getProductDetailsList()))
                .collect(Collectors.toList());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
