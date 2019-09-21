package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.errors.ApiRequestException;
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
        return productRepository.findAllByBrand(brand).orElseThrow( () -> new ApiRequestException("Nie znaleziono danej marki laptopa"));
    }

    public List<Product> findAll() {
        return productListConverter.convertIterableToList(productRepository.findAll());
    }

}
