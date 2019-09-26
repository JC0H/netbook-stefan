package pl.laptopy.polizingowe.service;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.laptopy.polizingowe.dto.ProductDTO;
import pl.laptopy.polizingowe.errors.ApiRequestException;
import pl.laptopy.polizingowe.model.Product;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ListConverter<Product> productListConverter;
    private final ProductRepository productRepository;

    public ProductService(ListConverter<Product> productListConverter, ProductRepository productRepository) {
        this.productListConverter = productListConverter;
        this.productRepository = productRepository;
    }

    @Transactional
    public List<ProductDTO> findAllByBrand(String brand) {
        return productRepository.findAllByBrand(brand).stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getBrand(), entity.getProductDetailsList()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> findAll() {
        return productListConverter.convertIterableToList(productRepository.findAll()).stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getBrand(), entity.getProductDetailsList()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setBrand(productDTO.getBrand());
        Product savedProduct = productRepository.save(newProduct);
        return new ProductDTO(savedProduct.getId(), savedProduct.getBrand());
    }

    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) {
        if (productRepository.findById(id).isPresent()){
            Product newProduct = productRepository.findById(id).get();
            newProduct.setBrand(productDTO.getBrand());

            Product updatedProduct = productRepository.save(newProduct);
            return new ProductDTO(updatedProduct.getId(), updatedProduct.getBrand());
        }else {
            return null;
        }
    }

    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
