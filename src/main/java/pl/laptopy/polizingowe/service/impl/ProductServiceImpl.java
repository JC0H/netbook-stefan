package pl.laptopy.polizingowe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.mapper.ProductCommandToProduct;
import pl.laptopy.polizingowe.mapper.ProductToProductCommand;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCommandToProduct productCommandToProduct;
    private final ProductToProductCommand productToProductCommand;

    public ProductServiceImpl(ProductRepository productRepository, ProductCommandToProduct productCommandToProduct, ProductToProductCommand productToProductCommand) {
        this.productRepository = productRepository;
        this.productCommandToProduct = productCommandToProduct;
        this.productToProductCommand = productToProductCommand;
    }

    @Override
    public List<Product> getProducts() {
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
    public ProductDto findCommandById(Long l) {
        return productToProductCommand.convert(findById(l));
    }

    @Override
    @Transactional
    public ProductDto saveProductCommand(ProductDto command) {
        Product product = productCommandToProduct.convert(command);

        Product saveProduct = productRepository.save(product);
        return productToProductCommand.convert(saveProduct);
    }

    @Override
    @Transactional
    public void deleteById(Long idToDelete) {
        productRepository.deleteById(idToDelete);
    }
}
