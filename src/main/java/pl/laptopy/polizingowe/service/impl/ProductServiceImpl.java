package pl.laptopy.polizingowe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.mapper.ProductDtoToProductMapper;
import pl.laptopy.polizingowe.mapper.ProductToProductDtoMapper;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoToProductMapper productDtoToProductMapper;
    private final ProductToProductDtoMapper productToProductDtoMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductDtoToProductMapper productDtoToProductMapper, ProductToProductDtoMapper productToProductDtoMapper) {
        this.productRepository = productRepository;
        this.productDtoToProductMapper = productDtoToProductMapper;
        this.productToProductDtoMapper = productToProductDtoMapper;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    @Override
    public Product findById(Long l) {
        Optional<Product> product = productRepository.findById(l);

        if (!product.isPresent()) {
            throw new RuntimeException("Product Not Found!");
        }
        return product.get();
    }

    @Override
    @Transactional
    public ProductDto findOneProduct(Long l) {
        return productToProductDtoMapper.convert(findById(l));
    }

    @Override
    @Transactional
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productDtoToProductMapper.convert(productDto);

        Product saveProduct = productRepository.save(product);
        return productToProductDtoMapper.convert(saveProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }
}
