package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.repository.ProductRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllByBrand(String brand) {
        return productRepository.findAllByBrand(brand).orElseThrow( () -> new IllegalArgumentException("There is no such brand"));
    }

}
