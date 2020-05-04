package pl.laptopy.polizingowe.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveMainImageFile(Long productId, MultipartFile file);

}