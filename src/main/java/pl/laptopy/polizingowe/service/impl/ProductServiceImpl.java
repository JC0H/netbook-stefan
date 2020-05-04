package pl.laptopy.polizingowe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.mapper.ProductMapper;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.service.ProductService;
import pl.laptopy.polizingowe.utils.ListConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ListConverter<Product> productListConverter;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ListConverter<Product> productListConverter) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productListConverter = productListConverter;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        if(!productsCount().equals(productDtoList.size())) {
            List<Product> products = productListConverter.convertIterableToList(productRepository.findAll());
            productDtoList = products.stream().map(productMapper::mapToProductDto).collect(Collectors.toList());
        }
        return productDtoList;
    }

    @Override
    @Transactional
    public ProductDto findOneProduct(Long productId) {
        return productMapper.mapToProductDto(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("no product with ID")));
    }

    @Override
    @Transactional
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }

    private Integer productsCount() {
        return Math.toIntExact(productRepository.count());
    }
}
