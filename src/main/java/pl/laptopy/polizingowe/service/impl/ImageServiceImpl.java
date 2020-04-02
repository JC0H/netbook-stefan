package pl.laptopy.polizingowe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.laptopy.polizingowe.entity.Product;
import pl.laptopy.polizingowe.repository.ProductRepository;
import pl.laptopy.polizingowe.service.ImageService;
import pl.laptopy.polizingowe.utils.ImageUtils;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {


    private final ProductRepository productRepository;

    public ImageServiceImpl(ProductRepository productService) {

        this.productRepository = productService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Product product = productRepository.findById(recipeId).get();

            ImageUtils.convertImageToBytes(file, product);

            productRepository.save(product);
        } catch (IOException e) {
            //todo handle
            e.printStackTrace();
        }
    }
}
