package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.repositorie.ProductRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllByBrand(String brand) {
        return productRepository.findAllByBrand(brand).orElseThrow( () -> new IllegalArgumentException("There is no such brand"));
    }

    public List<Product> findAllByModel(String model){
        return productRepository.findAllByModel(model).orElseThrow( () -> new IllegalArgumentException("There is no such model"));
    }
}
