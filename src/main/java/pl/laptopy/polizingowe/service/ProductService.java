package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ListConverter<Product> productListConverter;
    private final ProductRepository productRepository;

    public List<Product> findAllByBrand(String brand) {
        return productRepository.findAllByBrand(brand).orElseThrow( () -> new IllegalArgumentException("There is no such brand"));
    }

    public List<Product> findAll() {
        return productListConverter.convertIterableToList(productRepository.findAll());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
